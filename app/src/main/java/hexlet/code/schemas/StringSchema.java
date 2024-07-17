package hexlet.code.schemas;

import java.util.function.Predicate;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Predicate<Object> required = new Predicate<Object>() {
            @Override
            public boolean test(Object str) {
                return !str.equals("");
            }
        };

        addCheck("required", required);
        return this;

    }

    public StringSchema minLength(int length) {
        addCheck("minLength", s -> s.toString().length() >= length);
        return this;
    }

    public StringSchema contains(String stringContains) {
        addCheck("contains", s -> s.toString().contains(stringContains));
        return this;
    }

}
