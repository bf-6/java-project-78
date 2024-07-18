package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<Map<?, ?>> {
    public StringSchema required() {
        Predicate<Object> required = str -> !str.equals("");
        addCheck("required", required);

        return this;

    }

    public StringSchema minLength(int length) {
        Predicate<Object> minLength = str -> str.toString().length() >= length;

        addCheck("minLength", minLength);
        return this;
    }

    public StringSchema contains(String stringContains) {
        Predicate<Object> contains = str -> str.toString().contains(stringContains);
        addCheck("contains", contains);

        return this;
    }

}
