package hexlet.code.schemas;

/**
 * Абстрактный базовый класс для всех схем.
 * @param <T> тип данных для проверки
 */
public abstract class BaseSchema<T> {
    private boolean isRequired = false;

    /**
     * Устанавливает эту схему как обязательную.
     * @return экземпляр этой схемы
     */
    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    /**
     * Проверяет, отмечена ли эта схема как обязательная.
     * @return true, если эта схема обязательна, иначе false
     */
    public boolean isRequired() {
        return this.isRequired;
    }

    /**
     * Проверяет заданное значение на соответствие этой схеме.
     * @param value значение для проверки
     * @return true, если значение действительно, иначе false
     */
    public final boolean isValid(T value) {
        if (value == null) {
            return !this.isRequired;
        }
        return checkAdditionalConditions(value);
    }

    /**
     * Абстрактный метод для проверки дополнительных условий, специфичных для каждого типа схемы.
     * @param value значение для проверки
     * @return true, если значение соответствует всем условиям, иначе false
     */
    protected abstract boolean checkAdditionalConditions(T value);
}
