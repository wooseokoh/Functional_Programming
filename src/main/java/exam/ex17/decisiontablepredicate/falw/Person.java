package exam.ex17.decisiontablepredicate.falw;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.lang3.Range;

import static exam.ex17.decisiontablepredicate.falw.AgeGroup.*;

@Data
@AllArgsConstructor
public class Person {

    private int age;
    private Status status;

    public AgeGroup getAgeGroup() {
        if(Range.between(0, 7).contains(age)){
            return CHILD;
        }
        if(Range.between(8, 18).contains(age)){
            return YOUTH;
        }
        if(Range.between(19, 58).contains(age)){
            return ADULT;
        }
        return SENIOR;
    }
}
