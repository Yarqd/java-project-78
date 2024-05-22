package hexlet.code.schemas;

import java.util.Map;
import java.util.HashMap;

/**
 * Схема для проверки объектов типа Map.
 */
public class MapSchema extends BaseSchema<Map<String, Object>> {
    private Integer requiredSize = null;
    private Map<String, BaseSchema<?>> shapeSchemas = new HashMap<>();

    /**
     * Устанавливает эту схему как обязательную.
     * @return экземпляр этой схемы
     */
    public MapSchema required() {
        super.required();
        addCheck(value -> value != null && value instanceof Map);
        return this;
    }

    /**
     * Устанавливает размер карты для проверки.
     * @param size требуемый размер карты
     * @return экземпляр этой схемы
     */
    public MapSchema sizeof(int size) {
        this.requiredSize = size;
        addCheck(value -> value.size() == size);
        return this;
    }

    /**
     * Определяет набор схем для проверки значений каждого ключа карты.
     * @param schemas карта схем для проверки
     * @return экземпляр этой схемы
     */
    public MapSchema shape(Map<String, BaseSchema<?>> schemas) {
        this.shapeSchemas = new HashMap<>(schemas);
        addCheck(value -> {
            for (Map.Entry<String, BaseSchema<?>> entry : shapeSchemas.entrySet()) {
                String key = entry.getKey();
                BaseSchema<?> schema = entry.getValue();
                Object val = value.get(key);

                if (!schema.isValid(val)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
