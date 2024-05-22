package hexlet.code.schemas;

/**
 * Этот класс представляет схему для проверки чисел.
 */
public class NumberSchema extends BaseSchema<Integer> {
    /**
     * Устанавливает эту схему как обязательную.
     * @return экземпляр этой схемы
     */
    @Override
    public NumberSchema required() {
        super.required();
        addCheck(value -> value != null);
        return this;
    }

    /**
     * Устанавливает, что число должно быть положительным.
     * @return экземпляр этой схемы
     */
    public NumberSchema positive() {
        addCheck(value -> value > 0);
        return this;
    }

    /**
     * Устанавливает диапазон допустимых значений.
     * @param min минимальное значение
     * @param max максимальное значение
     * @return экземпляр этой схемы
     */
    public NumberSchema range(int min, int max) {
        addCheck(value -> value >= min && value <= max);
        return this;
    }
}
