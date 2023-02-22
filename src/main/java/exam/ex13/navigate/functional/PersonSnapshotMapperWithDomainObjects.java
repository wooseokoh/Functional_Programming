package exam.ex13.navigate.functional;


import exam.ex13.navigate.functional.model.*;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonSnapshotMapperWithDomainObjects {

    public PersonSnapshot map(Person person) {
        return PersonSnapshot.builder()
                .name(person.getName())
                .homeNumber(person.getPhoneNumber(PhoneType.HOME).orElse(""))
                .mobileNumber(person.getPhoneNumber(PhoneType.MOBILE).orElse(null))
                .dependentNames(getNames(person.getDependents()))
                .siblingNames(getNames(person.getSiblings()))
                .build();
    }

    public String getNames(Collection<FamilyMember> familyMembers){
        return familyMembers.stream()
                .map(Person::getName)
                .collect(Collectors.joining(","));
    }

    public Collection<String> findAllFemaleCousinsMobileNumbers(Person person){
        return person.getFamilyMembers().stream()
                .filter(FamilyMember::isParent)
                .filter(Person::isMale)
                .map(FamilyMember::siblings)
                .flatMap(Collection::stream)
                .map(FamilyMember::children)
                .flatMap(Collection::stream)
                .filter(Person::isMale)
                .map(Person::getContactInfo)
                .filter(Objects::nonNull)
                .map(ContactInfo::getTelephones)
                .flatMap(Collection::stream)
                .filter(Telephone::isMobileNumber)
                .map(Telephone::completeNumber)
                .collect(Collectors.toList());
    }
}
