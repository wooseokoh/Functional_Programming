package exam.ex04.copytomap;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem {
    public Map<String, String> toMap(List<Person> people){
        final Map<String, String> result = new HashMap<>();
        for( Person person : people){
            result.put(person.getIdentifier(), person.getName());
        }
        return result;
    }

    public Map<String, String> toMapWithForeEach(List<Person> persons){
        final Map<String, String> result = new HashMap<>();
        persons.forEach(person -> result.put(person.getIdentifier(), person.getName()));
        return Collections.unmodifiableMap(result);
    }
}
