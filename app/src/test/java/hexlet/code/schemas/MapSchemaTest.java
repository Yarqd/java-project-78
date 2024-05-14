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

        // Инициализируем схемы для валидации значений в Map
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required());  // Для firstName требуется непустое значение
        schemas.put("lastName", v.string().required().minLength(2)); // Для lastName требуется минимум 2 символа

        // Применяем схемы к MapSchema
        schema.shape(schemas);

        // Первый набор данных для тестирования
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertThat(schema.isValid(human1)).isTrue(); // Должен быть валидным

        // Второй набор данных для тестирования
        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertThat(schema.isValid(human2)).isFalse(); // Должен быть невалидным, т.к. lastName null

        // Третий набор данных для тестирования
        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertThat(schema.isValid(human3)).isFalse(); // Должен быть невалидным, т.к. lastName короче 2 символов
    }
}
