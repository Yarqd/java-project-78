package hexlet.code.schemas;

public class NumberSchema extends BaseSchema<Integer> {
    private boolean isPositive = false;
    private Integer minRange = null;
    private Integer maxRange = null;

    public final NumberSchema positive() {
        this.isPositive = true;
        addCheck(value -> value > 0);
        return this;
    }

    public final NumberSchema range(int min, int max) {
        this.minRange = min;
        this.maxRange = max;
        addCheck(value -> value >= minRange && value <= maxRange);
        return this;
    }

    @Override
    public final NumberSchema required() {
        super.required();
        return this;
    }
}
