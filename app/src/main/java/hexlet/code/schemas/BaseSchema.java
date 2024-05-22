package hexlet.code.schemas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Абстрактный базовый класс для всех схем.
 * @param <T> тип данных для валидации
 */
public abstract class BaseSchema<T> {
    private boolean isRequired = false;
    private final List<Predicate<T>> checks = new ArrayList<>();

    /**
     * Устанавливает эту схему как обязательную.
     * @return экземпляр этой схемы
     */
    public BaseSchema<T> required() {
        this.isRequired = true;
        addCheck(value -> value != null);
        return this;
    }

    /**
     * Добавляет проверку в список проверок.
     * @param check проверка для добавления
     */
    protected void addCheck(Predicate<T> check) {
        checks.add(check);
    }

    /**
     * Проверяет, является ли эта схема обязательной.
     * @return true если эта схема обязательна, иначе false
     */
    public boolean isRequired() {
        return isRequired;
    }

    /**
     * Проверяет значение по всем условиям.
     * @param value значение для проверки
     * @return true если значение соответствует всем условиям, иначе false
     */
    public final boolean isValid(Object value) {
        try {
            T castedValue = (T) value;
            if (castedValue == null) {
                return !isRequired;
            }
            for (Predicate<T> check : checks) {
                if (!check.test(castedValue)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException e) {
            return false;
        }
    }
}
