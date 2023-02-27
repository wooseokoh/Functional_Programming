package exam.ex17.decisiontablepredicate.falw;

import exam.ex17.decisiontablepredicate.SpecialProgram;

import static exam.ex17.decisiontablepredicate.falw.AgeGroup.*;

public class SpecialProgramDecisionMaker {

    // If case
    public SpecialProgram getSpecialProgramByIF1(Person person) {
        final Status status = person.getStatus();
        if (status == Status.CITIZEN) {
            if (person.getAgeGroup() == AgeGroup.CHILD) {
                return SpecialProgram.A;
            }
            if (person.getAgeGroup() == AgeGroup.ADULT) {
                return SpecialProgram.C;
            }
            return SpecialProgram.B;

        } else if (status == Status.WORK_PERMIT) {
            if (person.getAgeGroup() == AgeGroup.CHILD) {
                return SpecialProgram.B;
            }
            if (person.getAgeGroup() == AgeGroup.ADULT) {
                return SpecialProgram.D;
            }
            return SpecialProgram.C;

        } else if (status == Status.VISITOR) {
            if (person.getAgeGroup() == AgeGroup.CHILD) {
                return SpecialProgram.B;
            }
            if (person.getAgeGroup() == AgeGroup.ADULT) {
                return SpecialProgram.N_A;
            }
            return SpecialProgram.D;
        }
        throw new IllegalArgumentException("Person has not valid status: " + status);
    }

    // SWITCH case
    public SpecialProgram getSpecialProgramBySwitch(Person person) {
        return switch (person.getStatus()){
            case CITIZEN -> citizenProgram(person);
            case WORK_PERMIT -> workPermitProgram(person);
            case VISITOR -> visitorProgram(person);
        };
    }

    private SpecialProgram citizenProgram(Person person){
        return switch (person.getAgeGroup()){
            case CHILD -> SpecialProgram.A;
            case YOUTH, SENIOR -> SpecialProgram.B;
            case ADULT -> SpecialProgram.C;
        };
    }

    private SpecialProgram workPermitProgram(Person person){
        return switch (person.getAgeGroup()){
            case CHILD -> SpecialProgram.B;
            case YOUTH, SENIOR -> SpecialProgram.C;
            case ADULT -> SpecialProgram.D;
        };
    }

    private SpecialProgram visitorProgram(Person person){
        return switch (person.getAgeGroup()){
            case CHILD -> SpecialProgram.B;
            case YOUTH, SENIOR -> SpecialProgram.D;
            case ADULT -> SpecialProgram.N_A;
        };
    }

    public SpecialProgram getSpecialProgramByIF2(Person person) {
        final Status status = person.getStatus();
        if (status == Status.CITIZEN && person.getAgeGroup() == CHILD) {
            return SpecialProgram.A;
        }
        if ((status == Status.CITIZEN && (person.getAgeGroup() == YOUTH ||
                person.getAgeGroup() == SENIOR)) || (person.getAgeGroup() == CHILD && (status == Status.WORK_PERMIT || status == Status.VISITOR))){
            return SpecialProgram.B;
        }
        if ((status == Status.CITIZEN && person.getAgeGroup() == AgeGroup.ADULT) ||
                (status == Status.WORK_PERMIT && (person.getAgeGroup() == YOUTH || person.getAgeGroup() == SENIOR))){
            return SpecialProgram.C;
        }
        if ((status == Status.WORK_PERMIT && person.getAgeGroup() == AgeGroup.ADULT) ||
                (status == Status.VISITOR && (person.getAgeGroup() == YOUTH || person.getAgeGroup() == SENIOR))){
            return SpecialProgram.D;
        }
        return SpecialProgram.N_A;
    }
}
