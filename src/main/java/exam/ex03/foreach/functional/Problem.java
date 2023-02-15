package exam.ex03.foreach.functional;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Problem {

    public List<Person> populateAge(List<Person> people){
        people.forEach(person -> person.setAge(getAge(person.getBirthDate())));
        return people;
    }

    private int getAge(LocalDate birthDate) {
        final LocalDate now = LocalDate.now();
        return Period.between(birthDate, now).getYears();
    }
}
