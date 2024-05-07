package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;

/**
 * This class provides methods to create various types of validation schemas.
 */
public class Validator {

    /**
     * Creates and returns a new StringSchema.
     * @return a new instance of StringSchema
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Creates and returns a new NumberSchema.
     * @return a new instance of NumberSchema
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Creates and returns a new MapSchema.
     * @return a new instance of MapSchema
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
