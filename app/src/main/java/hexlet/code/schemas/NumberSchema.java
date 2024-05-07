package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean isPositive = false;
    private Integer minRange = null;
    private Integer maxRange = null;

    public final NumberSchema positive() {
        this.isPositive = true;
        return this;
    }

    public final NumberSchema range(int min, int max) {
        this.minRange = min;
        this.maxRange = max;
        return this;
    }

    @Override
    protected final boolean checkAdditionalConditions(Integer value) {
        if (isPositive && value <= 0) {
            return false;
        }
        if (minRange != null && (value < minRange || value > maxRange)) {
            return false;
        }
        return true;
    }
}
