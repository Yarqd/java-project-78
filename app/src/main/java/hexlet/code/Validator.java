package hexlet.code;

import hexlet.code.schemas.StringSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.MapSchema;

/**
 * Класс предоставляет методы для создания различных типов схем валидации.
 */
public class Validator {

    /**
     * Создает и возвращает новый объект StringSchema.
     * @return новый экземпляр StringSchema
     */
    public StringSchema string() {
        return new StringSchema();
    }

    /**
     * Создает и возвращает новый объект NumberSchema.
     * @return новый экземпляр NumberSchema
     */
    public NumberSchema number() {
        return new NumberSchema();
    }

    /**
     * Создает и возвращает новый объект MapSchema.
     * @return новый экземпляр MapSchema
     */
    public MapSchema map() {
        return new MapSchema();
    }
}
