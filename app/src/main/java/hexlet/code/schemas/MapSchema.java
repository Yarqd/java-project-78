package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;

/**
 * Этот класс представляет схему для проверки объектов типа Map.
 */
public class MapSchema extends BaseSchema<Map<String, Object>> {
    private Map<String, BaseSchema<?>> shapeSchemas = new HashMap<>();

    /**
     * Устанавливает эту схему как обязательную.
     * @return экземпляр этой схемы
     */
    @Override
    public MapSchema required() {
        super.required();
        addCheck(value -> value != null);
        return this;
    }

    /**
     * Устанавливает количество пар ключ-значение в объекте Map.
     * @param size количество пар ключ-значение
     * @return экземпляр этой схемы
     */
    public MapSchema sizeof(int size) {
        addCheck(value -> value.size() == size);
        return this;
    }

    /**
     * Устанавливает набор схем для проверки значений по ключам объекта Map.
     * @param schemas набор схем
     * @return экземпляр этой схемы
     */
    public MapSchema shape(Map<String, BaseSchema<?>> schemas) {
        this.shapeSchemas = schemas;
        addCheck(this::validateShape);
        return this;
    }

    private boolean validateShape(Map<String, Object> value) {
        for (Map.Entry<String, BaseSchema<?>> entry : shapeSchemas.entrySet()) {
            String key = entry.getKey();
            BaseSchema<?> schema = entry.getValue();
            Object val = value.get(key);

            // Приведение типов к Object
            if (!schema.isValid(val)) {
                return false;
            }
        }
        return true;
    }
}
