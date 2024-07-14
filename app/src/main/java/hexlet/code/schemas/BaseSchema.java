package hexlet.code.schemas;

import java.util.*;
import java.util.function.*;

public abstract class BaseSchemas {

        protected Map<String, Predicate<Object>> checks = new LinkedHashMap<>();
        protected boolean required = false;

        protected final void addCheck(String name, Predicate<Object> validate) {
            checks.put(name, validate);
        }

        public final boolean isValid(Object ourData) {
            return false;
        }

}
