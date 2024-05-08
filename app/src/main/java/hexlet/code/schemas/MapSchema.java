package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;

public class MapSchema extends BaseSchema<Map<String, Object>> {
    private Integer requiredSize = null;
    private Map<String, BaseSchema<?>> shapeSchemas = new HashMap<>();

    public final MapSchema required() {
        super.required();
        return this;
    }

    public final MapSchema sizeof(int size) {
        this.requiredSize = size;
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema<?>> schemas) {
        this.shapeSchemas = schemas;
        return this;
    }

    @Override
    protected final boolean checkAdditionalConditions(Map<String, Object> value) {
        if (requiredSize != null && (value == null || value.size() != requiredSize)) {
            return false;
        }
        if (!shapeSchemas.isEmpty()) {
            for (Map.Entry<String, BaseSchema<?>> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object val = value.get(key);

                if (!value.containsKey(key) || !schema.validate(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}
