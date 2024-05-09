package hexlet.code.schemas;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class TestSchemaTest {
    private static final int MIN_LENGTH = 5;

    @Test
    public void testRequired() {
        TestSchema schema = new TestSchema();
        assertThat(schema.isValid(null)).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
    }

    @Test
    public void testIsValid() {
        TestSchema schema = new TestSchema();
        assertThat(schema.isValid("valid")).isTrue();
        assertThat(schema.isValid("invalid")).isFalse();
    }

    @Test
    public void testValidate() {
        TestSchema schema = new TestSchema();
        assertThat(schema.validate("valid")).isTrue();
        assertThat(schema.validate("invalid")).isFalse();

        assertThat(schema.validate(MIN_LENGTH)).isFalse();
    }
}
