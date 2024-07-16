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

    public MapSchema shape(Map<String, BaseSchema<Object>> schemas) {
        addCheck(
                "shape",
                value -> {
                    boolean isValid = true;
                    Map<String, BaseSchema> objectMap = (Map<String, BaseSchema>) value;
                    for (Map.Entry entry : objectMap.entrySet()) {
                        if (!schemas.get(entry.getKey()).isValid(entry.getValue())) {
                            isValid = false;
                        }
                    }
                    return isValid;
                }
        );
        return this;
    }

}
