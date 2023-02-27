package exam.ex17.decisiontablepredicate.functional;

import exam.ex17.decisiontablepredicate.SpecialProgram;

import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static exam.ex17.decisiontablepredicate.SpecialProgram.*;
import static exam.ex17.decisiontablepredicate.functional.PersonPredicates.*;

public class SpecialProgramDecisionMaker implements DecisionMaker<Person, SpecialProgram>{

    private final Map<Predicate<Person>, SpecialProgram> decisions = Map.of(
            (CITIZEN.and(CHILD)), A,

            (CITIZEN.and(WORK_PERMIT.or(VISITOR)))
                    .or
            (CITIZEN.and(YOUTH.or(SENIOR))), B,

            (ADULT.and(CITIZEN))
                    .or
            (WORK_PERMIT.and(YOUTH.or(SENIOR))), C,

            (ADULT.and(WORK_PERMIT))
                    .or
            (VISITOR.and(YOUTH.or(SENIOR))), D

    );

    @Override
    public Map<Predicate<Person>, SpecialProgram> getDecisions() {
        return decisions;
    }

    @Override
    public Supplier<SpecialProgram> defaultDecision() {
        return () -> N_A;
    }
}
