package exam.ex17.decisiontablepredicate.functional;

import java.util.function.Predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonPredicates {

    public static final Predicate<Person> CHILD = Person::isChild;
    public static final Predicate<Person> YOUTH = Person::isYouth;
    public static final Predicate<Person> ADULT = Person::isAdult;
    public static final Predicate<Person> SENIOR = Person::isSenior;

    public static final Predicate<Person> CITIZEN = Person::isCitizen;
    public static final Predicate<Person> WORK_PERMIT = Person::hasWorkPermit;
    public static final Predicate<Person> VISITOR = Person::isVisitor;
}