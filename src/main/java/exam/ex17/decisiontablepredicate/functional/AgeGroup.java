package exam.ex17.decisiontablepredicate.functional;

import org.apache.commons.lang3.Range;

import java.util.function.Predicate;

public enum AgeGroup implements Predicate<Person> {
    CHILD, YOUTH, ADULT, SENIOR;

    public static AgeGroup of(int age){
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
