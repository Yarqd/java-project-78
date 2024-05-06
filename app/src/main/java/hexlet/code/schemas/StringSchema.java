package hexlet.code.schemas;

public class StringSchema {
    private boolean required = false;
    private int minLength = -1;
    private String substring = null;

    public final StringSchema required() {
        this.required = true;
        return this;
    }

    public final StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public final StringSchema contains(String substr) {
        this.substring = substr;
        return this;
    }

    public final boolean isValid(String value) {
        if (value == null) {
            return !required;
        }
        if (value.isEmpty() && required) {
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
