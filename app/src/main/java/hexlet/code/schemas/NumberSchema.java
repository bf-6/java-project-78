package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Map<?, ?>>{

    public NumberSchema required() {
        Predicate<Object> required = number -> number != null;
        addCheck("required", required);

        return this;
    }

    public NumberSchema positive() {
        Predicate<Object> positive = number -> number == null || (int) number > 0;
        addCheck("positive", positive);

        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Object> range = number -> (int) number >= min && (int) number <= max;

        addCheck("range", range);
        return this;
    }

}
