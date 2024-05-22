package hexlet.code.schemas;

/**
 * Тестовая схема для проверки корректности работы базовой схемы.
 */
public class TestSchema extends BaseSchema<String> {
    public TestSchema() {
        addCheck(this::isValueValid);
    }

    private boolean isValueValid(String value) {
        return "valid".equals(value);
    }
}
