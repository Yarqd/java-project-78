package hexlet.code.schemas;

/**
 * Этот класс представляет схему для валидации строк.
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
        addCheck(value -> !value.isEmpty());
        return this;
    }

    /**
     * Устанавливает минимальную длину строки.
     * @param length минимальная длина
     * @return экземпляр этой схемы
     */
    public StringSchema minLength(int length) {
        this.minLength = length;
        addCheck(value -> value.length() >= minLength);
        return this;
    }

    /**
     * Устанавливает подстроку, которую должна содержать строка.
     * @param substr подстрока
     * @return экземпляр этой схемы
     */
    public StringSchema contains(String substr) {
        this.substring = substr;
        addCheck(value -> value.contains(substring));
        return this;
    }
}
