package exam.ex13.navigate.functional;

import exam.ex13.navigate.before.model.*;

public class PersonSnapshotMapper {

    public PersonSnapshot map(Person person) {
        return PersonSnapshot.builder()
                .name(person.getName())
                .homeNumber(getPhoneNumber(person, PhoneType.HOME))
                .mobileNumber(getPhoneNumber(person, PhoneType.MOBILE))
                .dependentNames(getDependentNames(person))
                .siblingNames(getSiblingNames(person))
                .build();
    }

    private String getPhoneNumber(Person person, PhoneType phoneType) {
        return NodeFinder.phoneNumber(person, telephone -> telephone.getPhoneType() == phoneType)
                .map(Telephone::getNumber)
                .orElse(null);
    }

    private String getDependentNames(Person person) {
        return String.join(",",
                NodeFinder.familyMemberNames(person, FamilyMember::isDependent));
    }

    private String getSiblingNames(Person person) {
        return String.join(",",
                NodeFinder.familyMemberNames(person, familyMember -> familyMember.getRelationType() == RelationType.SIBLING));
    }
}