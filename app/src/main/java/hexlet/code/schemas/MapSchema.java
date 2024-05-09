package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;

public class MapSchema extends BaseSchema<Map<String, Object>> {
    private Integer requiredSize = null;
    // Используйте Map<String, ? extends BaseSchema<?>> для более гибкой совместимости
    private Map<String, ? extends BaseSchema<?>> shapeSchemas = new HashMap<>();

    public final MapSchema required() {
        super.required();
        return this;
    }

    public final MapSchema sizeof(int size) {
        this.requiredSize = size;
        return this;
    }

    // Принимайте Map<String, ? extends BaseSchema<?>> для большей совместимости с тестами
    public final MapSchema shape(Map<String, ? extends BaseSchema<?>> schemas) {
        this.shapeSchemas = schemas;
        return this;
    }

    @Override
    protected final boolean checkAdditionalConditions(Map<String, Object> value) {
        if (requiredSize != null && (value == null || value.size() != requiredSize)) {
            return false;
        }
        // Проверка на соответствие каждому ключу согласно определённой схеме
        if (!shapeSchemas.isEmpty()) {
            for (Map.Entry<String, ? extends BaseSchema<?>> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object val = value != null ? value.get(key) : null;

                if (!value.containsKey(key) || !schema.validate(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}
