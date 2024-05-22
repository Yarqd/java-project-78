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
        addCheck(value -> value.size() == size);
        return this;
    }

    public final MapSchema shape(Map<String, BaseSchema<?>> schemas) {
        this.shapeSchemas = schemas;
        addCheck(value -> {
            for (Map.Entry<String, BaseSchema<?>> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object val = value.get(key);

                if (!value.containsKey(key) || !schema.isValid(val)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
