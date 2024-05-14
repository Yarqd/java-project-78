package hexlet.code.schemas;

/**
 * Этот класс представляет схему для проверки строк.
 */
public class StringSchema extends BaseSchema<String> {

    private int minLength = -1;
    private String substring = null;

    /**
     * Устанавливает эту схему как обязательную.
     * @return экземпляр этой схемы
     */
    public StringSchema required() {
        super.required();
        return this;
    }

    /**
     * Устанавливает минимальную длину для строки.
     * @param length минимальная длина
     * @return экземпляр этой схемы
     */
    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    /**
     * Устанавливает подстроку, которую должна содержать строка.
     * @param substr подстрока для проверки
     * @return экземпляр этой схемы
     */
    public StringSchema contains(String substr) {
        this.substring = substr;
        return this;
    }

    /**
     * Проверяет дополнительные условия, специфичные для этой схемы.
     * @param value строка для проверки
     * @return true, если строка соответствует всем условиям, иначе false
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
