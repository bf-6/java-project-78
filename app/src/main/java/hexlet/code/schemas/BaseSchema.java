package hexlet.code.schemas;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {

    protected Map<String, Predicate<T>> checks = new LinkedHashMap<>();
    protected boolean required = false;

    protected final void addCheck(String name, Predicate<T> validate) {
        checks.put(name, validate);
    }

    public final boolean isValid(T ourData) {

        if (ourData == null && checks.containsKey("required")) {
            return required;
        }

        for (Map.Entry<String, Predicate<T>> check : checks.entrySet()) {
            if (!check.getValue().test(ourData)) {
                return false;
            }
        }

        return true;

    }

}
