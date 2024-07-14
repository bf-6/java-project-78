package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema {

    public void required() {
        Predicate<Object> required = new Predicate<Object>() {
            @Override
            public boolean test(Object map) {
                return map != null;
            }
        };

        addCheck("required", required);

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

}
