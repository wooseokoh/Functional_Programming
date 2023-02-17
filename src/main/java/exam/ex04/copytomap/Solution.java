package exam.ex04.copytomap;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public Map<String, String> toMap(List<Person> people){
        return  people.stream()
                .map(person -> new AbstractMap.SimpleImmutableEntry<>(person.getIdentifier(), person.getName()))
                .collect(Collectors.toMap(AbstractMap.SimpleImmutableEntry::getKey,AbstractMap.SimpleImmutableEntry::getValue));
    }
}
