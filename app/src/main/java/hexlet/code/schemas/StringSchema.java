package hexlet.code.schemas;

/**
 * Этот класс представляет схему для проверки строк.
 */
public class StringSchema extends BaseSchema<String> {
    /**
     * Устанавливает эту схему как обязательную.
     * @return экземпляр этой схемы
     */
    @Override
    public StringSchema required() {
        super.required();
        addCheck(value -> !value.isEmpty());
        return this;
    }

    /**
     * Устанавливает минимальную длину для строки.
     * @param length минимальная длина
     * @return экземпляр этой схемы
     */
    public StringSchema minLength(int length) {
        addCheck(value -> value.length() >= length);
        return this;
    }

    /**
     * Устанавливает подстроку, которую должна содержать строка.
     * @param substr подстрока для проверки
     * @return экземпляр этой схемы
     */
    public StringSchema contains(String substr) {
        addCheck(value -> value.contains(substr));
        return this;
    }
}
