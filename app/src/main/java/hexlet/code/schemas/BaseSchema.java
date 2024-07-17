package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema<S> {

    protected Map<String, Predicate<Object>> checks = new LinkedHashMap<>();
    protected boolean required = false;

    protected final void addCheck(String name, Predicate<Object> validate) {
        checks.put(name, validate);
    }

    public final boolean isValid(Object ourData) {

        if (ourData == null && checks.containsKey("required")) {
            return required;
        }

        for (Map.Entry<String, Predicate<Object>> check : checks.entrySet()) {
            if (!check.getValue().test(ourData)) {
                return false;
            }
        }

        return true;

    }

}
