package exam.ex03.foreach.functional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<Person> populateAge(List<Person> people){
        return people.stream()
                        .map(person -> person.toBuilder()
                                .age(getAge(person.getBirthDate()))
                                .build())
                                .collect(Collectors.toList());
    }

    private int getAge(LocalDate birthDate) {
        final LocalDate now = LocalDate.now();
        return Period.between(birthDate, now).getYears();
    }
}
