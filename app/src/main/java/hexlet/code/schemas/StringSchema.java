package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Predicate<String> required = str -> !str.equals("");

        addCheck("required", required);
        return this;
    }

    public StringSchema minLength(int length) {
        Predicate<String> minLength = str -> str.toString().length() >= length;

        addCheck("minLength", minLength);
        return this;
    }

    public StringSchema contains(String stringContains) {
        Predicate<String> contains = str -> str.toString().contains(stringContains);
        addCheck("contains", contains);

        return this;
    }

}
