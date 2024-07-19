package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        Predicate<Map<?, ?>> required = map -> map != null;

        addCheck("required", required);
        return this;
    }

    public MapSchema sizeof(int size) {
        Predicate<Map<?, ?>> sizeof = map -> ((Map<?, ?>) map).size() == size;

        addCheck("sizeof", sizeof);
        return this;
    }

    public MapSchema shape(Map<String, ? extends BaseSchema> schemaMap) {
        Predicate<Map<?, ?>> shape = map -> schemaMap.entrySet()
                .stream()
                .allMatch(entry -> entry.getValue().isValid(((Map<?, ?>) map).get(entry.getKey())));

        addCheck("shape", shape);
        return this;
    }

}
