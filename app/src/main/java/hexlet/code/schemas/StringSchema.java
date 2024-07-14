package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public class StringSchemas extends BaseSchemas {

    public StringSchemas required() {
        Predicate<String> required = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return !str.equals("") && str instanceof String;
            }
        };
//       Predicate<Object> stringPredicate = new Predicate<Object>() {
//           @Override
//           public boolean test(Object o) {
//               return !o.equals("") && o instanceof String;
//           }
//       };
       //addCheck("required", s -> !Objects.equals(s, "") && s instanceof String);
       return this;
   }

    public StringSchemas minLength(int length) {
        addCheck("minLength", s -> s.toString().length() >= length);
        return this;
    }

    public StringSchemas contains(String stringContains) {
        addCheck("contains", s -> s.toString().contains(stringContains));
        return this;
    }

}
