package hexlet.code.schemas;

/**
 * Abstract base class for all schemas.
 * @param <T> the type of data to validate
 */
public abstract class BaseSchema<T> {
    private boolean isRequired = false;

    /**
     * Sets this schema as required.
     * @return this schema instance
     */
    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    /**
     * Checks if this schema is marked as required.
     * @return true if this schema is required, false otherwise
     */
    public boolean isRequired() {
        return this.isRequired;
    }

    /**
     * Validates the given value against this schema.
     * @param value the value to validate
     * @return true if the value is valid, false otherwise
     */
    public final boolean isValid(T value) {
        if (value == null) {
            return !this.isRequired;
        }
        return checkAdditionalConditions(value);
    }

    /**
     * Abstract method to check additional conditions specific to each schema type.
     * @param value the value to validate
     * @return true if the value meets all conditions, false otherwise
     */
    protected abstract boolean checkAdditionalConditions(T value);
}
