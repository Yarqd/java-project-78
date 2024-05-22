package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;

/**
 * Схема для проверки объектов типа Map.
 */
public class MapSchema extends BaseSchema<Map<String, Object>> {
    private Integer requiredSize = null;
    private Map<String, BaseSchema<?>> shapeSchemas = new HashMap<>();

    public MapSchema required() {
        super.required();
        addCheck(value -> value != null && value instanceof Map);
        return this;
    }

    public MapSchema sizeof(int size) {
        this.requiredSize = size;
        addCheck(value -> value.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<?>> schemas) {
        this.shapeSchemas = new HashMap<>(schemas);
        addCheck(value -> {
            for (Map.Entry<String, BaseSchema<?>> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object val = value.get(key);

                if (!schema.isValid(val)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
