package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.Map;

public class StringSchemaTest {
    private static final int MIN_LENGTH = 5;

    @Test
    public void testRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string().required();

        assertThat(schema.isValid("")).isFalse();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid("hexlet")).isTrue();
    }

    @Test
    public void testMinLengthWithRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string().minLength(MIN_LENGTH).required();

        assertThat(schema.isValid("hex")).isFalse();
        assertThat(schema.isValid("hexlet")).isTrue();
        assertThat(schema.isValid("")).isFalse();
    }

    @Test
    public void testContains() {
        Validator v = new Validator();
        StringSchema schema = v.string().contains("hex");

        assertThat(schema.isValid("hexlet")).isTrue();
        assertThat(schema.isValid("example")).isFalse();
    }

    @Test
    public void testCombined() {
        Validator v = new Validator();
        StringSchema schema = v.string().required().minLength(MIN_LENGTH).contains("hex");

        assertThat(schema.isValid("hexlet")).isTrue();
        assertThat(schema.isValid("hello")).isFalse(); // Does not contain "hex"
        assertThat(schema.isValid("hex")).isFalse(); // Does not meet minLength
        assertThat(schema.isValid(null)).isFalse();
    }

    @Test
    public void testEmptyStringIsValidIfNotRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string(); // Not required

        assertThat(schema.isValid("")).isTrue();
    }

    @Test
    public void testMapValidation() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertThat(schema.isValid(data)).isTrue();

        schema.sizeof(2);
        assertThat(schema.isValid(data)).isFalse();
        data.put("key2", "value2");
        assertThat(schema.isValid(data)).isTrue();
    }
}
