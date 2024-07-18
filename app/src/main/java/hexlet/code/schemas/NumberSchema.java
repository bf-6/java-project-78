package hexlet.code.schemas;

import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema {

    public NumberSchema required() {
        Predicate<Object> required = new Predicate<Object>() {
            @Override
            public boolean test(Object number) {
                return number != null;
            }
        };

        addCheck("required", required);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> positive = new Predicate<Object>() {
            @Override
            public boolean test(Object number) {
                return number == null || (int) number > 0;
            }
        };
        addCheck("positive", positive);
        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Object> range = new Predicate<Object>() {
            @Override
            public boolean test(Object number) {
                return (int) number >= min && (int) number <= max;
            }
        };
        addCheck("range", range);
        return this;
    }

}
