package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<?, ?>> {

    public MapSchema required() {
        Predicate<Object> required = map -> map != null;

        addCheck("required", required);
        return this;

    }

    public MapSchema sizeof(int size) {
        Predicate<Object> sizeof = map -> ((Map<?, ?>) map).size() == size;

        addCheck("sizeof", sizeof);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemaMap) {
        Predicate<Object> shape = map -> schemaMap.entrySet()
                .stream()
                .allMatch(entry -> entry.getValue().isValid(((Map<?, ?>) map).get(entry.getKey())));

        addCheck("shape", shape);
        return this;
    }

}
