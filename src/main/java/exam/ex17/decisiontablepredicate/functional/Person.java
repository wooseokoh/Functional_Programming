package exam.ex17.decisiontablepredicate.functional;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private int age;
    private Status status;

    public boolean isChild(){
        return AgeGroup.of(getAge()) == AgeGroup.CHILD;
    }
    public boolean isYouth(){
        return AgeGroup.of(getAge()) == AgeGroup.YOUTH;
    }
    public boolean isAdult(){
        return AgeGroup.of(getAge()) == AgeGroup.ADULT;
    }
    public boolean isSenior(){
        return AgeGroup.of(getAge()) == AgeGroup.SENIOR;
    }

    public boolean isCitizen(){
        return getStatus() == Status.CITIZEN;
    }
    public boolean hasWorkPermit(){
        return getStatus() == Status.WORK_PERMIT;
    }
    public boolean isVisitor(){
        return getStatus() == Status.VISITOR;
    }
}
