package hexlet.code.schemas;

import hexlet.code.Validator;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.HashMap;
import static org.assertj.core.api.Assertions.assertThat;

public class MapSchemaTest {

    @Test
    public void testShapeValidation() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema<?>> schemas = new HashMap<>();
        schemas.put("firstName", (BaseSchema<?>) v.string().required());
        schemas.put("lastName", (BaseSchema<?>) v.string().required().minLength(2));

        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertThat(schema.isValid(human1)).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertThat(schema.isValid(human2)).isFalse();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertThat(schema.isValid(human3)).isFalse();
    }
}
