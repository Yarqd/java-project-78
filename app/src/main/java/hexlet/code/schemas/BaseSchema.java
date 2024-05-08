package hexlet.code.schemas;

public abstract class BaseSchema<T> {
    private boolean isRequired = false;

    /**
     * Устанавливает схему как обязательную для валидации.
     * @return Возвращает текущий объект схемы с установленным флагом обязательности.
     */

    public BaseSchema<T> required() {
        this.isRequired = true;
        return this;
    }

    /**
     * Проверяет, соответствует ли предоставленное значение определенным условиям схемы.
     * Этот метод следует переопределять в подклассах для добавления специфичных для типа проверок.
     *
     * @param value значение, которое нужно проверить
     * @return true, если значение соответствует схеме, иначе false
     */
    public boolean isValid(T value) {
        if (value == null) {
            return !isRequired;
        }
        return checkAdditionalConditions(value);
    }

    public final boolean validate(Object value) {
        try {
            T castedValue = (T) value;
            return isValid(castedValue);
        } catch (ClassCastException e) {
            return false;
        }
    }

    protected abstract boolean checkAdditionalConditions(T value);
}
