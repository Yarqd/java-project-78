package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;

public class MapSchema extends BaseSchema<Map<String, String>> {
    private Integer requiredSize = null;
    private Map<String, ? extends BaseSchema<String>> shapeSchemas = new HashMap<>();

    public final MapSchema required() {
        super.required();
        return this;
    }

    public final MapSchema sizeof(int size) {
        this.requiredSize = size;
        return this;
    }

    public final MapSchema shape(Map<String, ? extends BaseSchema<String>> schemas) {
        this.shapeSchemas = schemas;
        return this;
    }

    @Override
    protected final boolean checkAdditionalConditions(Map<String, String> value) {
        if (requiredSize != null && (value == null || value.size() != requiredSize)) {
            return false;
        }
        if (!shapeSchemas.isEmpty()) {
            for (Map.Entry<String, ? extends BaseSchema<String>> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<String> schema = entry.getValue();
                String val = value != null ? value.get(key) : null;

                if (!value.containsKey(key) || !schema.isValid(val)) {
                    return false;
                }
            }
        }
        return true;
    }
}
