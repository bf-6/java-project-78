package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public MapSchema required() {
        Predicate<Object> required = new Predicate<Object>() {
            @Override
            public boolean test(Object map) {
                return map != null;
            }
        };

        addCheck("required", required);
        return this;

    }

    public MapSchema sizeof(int size) {
        Predicate<Object> sizeof = new Predicate<Object>() {
            @Override
            public boolean test(Object map) {
                return ((Map<?, ?>) map).size() == size;
            }
        };
        addCheck("sizeof", sizeof);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<Object>> schemasMap) {

        Predicate<Object> shape = new Predicate<Object>() {
            @Override
            public boolean test(Object o) {
                Map<String, BaseSchema> objectMap = (Map<String, BaseSchema>) o;
                for (Map.Entry map : objectMap.entrySet()) {
                    if (!schemasMap.get(map.getKey()).isValid(map.getValue())) {
                        return false;
                    }
                }
                return true;
            }
        };

        addCheck("shape", shape);
        return this;
    }

}
