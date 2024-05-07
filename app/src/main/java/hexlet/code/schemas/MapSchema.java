package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<?, ?>> {
    private Integer requiredSize = null;

    public final MapSchema required() {
        super.required();
        return this;
    }

    public final MapSchema sizeof(int size) {
        this.requiredSize = size;
        return this;
    }

    @Override
    protected final boolean checkAdditionalConditions(Map<?, ?> value) {
        if (requiredSize != null && value.size() != requiredSize) {
            return false;
        }
        return true;
    }
}
