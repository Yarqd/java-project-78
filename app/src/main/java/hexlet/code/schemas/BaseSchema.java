package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    private boolean isRequired = false;

    /**
     *
     * @return qwerty
     */
    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    public final boolean isValid(T value) {
        if (value == null) {
            return !isRequired;
        }
        return checkAdditionalConditions(value);
    }

    protected abstract boolean checkAdditionalConditions(T value);
}
