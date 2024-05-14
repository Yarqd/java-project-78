package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringSchemaTest {
    private static final int MIN_LENGTH = 5;

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
    public void testEmptyStringIsValidIfNotRequired() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid("")).isTrue();
    }
}
