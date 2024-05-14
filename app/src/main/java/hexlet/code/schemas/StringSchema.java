package hexlet.code.schemas;

/**
 * This class represents the schema for string validation.
 */
public class StringSchema extends BaseSchema<String> {

    private int minLength = -1;
    private String substring = null;

    /**
     * Sets this schema as required.
     * @return this schema instance
     */
    public StringSchema required() {
        super.required();
        return this;
    }

    /**
     * Sets the minimum length for the string.
     * @param length the minimum length to set
     * @return this schema instance
     */
    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    /**
     * Sets the substring that the string should contain.
     * @param substr the substring to check for
     * @return this schema instance
     */
    public StringSchema contains(String substr) {
        this.substring = substr;
        return this;
    }

    /**
     * Checks additional conditions specific to this schema.
     * @param value the string to validate
     * @return true if the string meets all conditions, false otherwise
     */
    @Override
    protected boolean checkAdditionalConditions(String value) {
        if (value.isEmpty() && this.isRequired()) {
            return false;
        }
        if (value.length() < minLength && minLength != -1) {
            return false;
        }
        if (substring != null && !value.contains(substring)) {
            return false;
        }
        return true;
    }
}
