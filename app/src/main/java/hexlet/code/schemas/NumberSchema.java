package hexlet.code.schemas;


import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema required() {
        Predicate<Integer> required = number -> number != null;
        addCheck("required", required);

        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> positive = number -> number == null || (int) number > 0;
        addCheck("positive", positive);

        return this;
    }

    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = number -> (int) number >= min && (int) number <= max;

        addCheck("range", range);
        return this;
    }

}
