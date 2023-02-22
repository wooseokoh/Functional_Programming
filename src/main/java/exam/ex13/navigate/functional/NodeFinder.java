package exam.ex13.navigate.functional;

import exam.ex13.navigate.before.model.ContactInfo;
import exam.ex13.navigate.before.model.FamilyMember;
import exam.ex13.navigate.before.model.Person;
import exam.ex13.navigate.before.model.Telephone;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NodeFinder {

    public static Collection<Telephone> telephones(Person person) {
        return Optional.of(person)
                .map(Person::getContactInfo)
                .map(ContactInfo::getPhoneNumbers)
                .orElse(Collections.emptyList());
    }

    public static Optional<Telephone> phoneNumber(Person person, Predicate<Telephone> predicate) {
        return telephones(person)
                .stream()
                .filter(predicate)
                .findFirst();
    }

    public static Collection<String> familyMemberNames(Person person, Predicate<FamilyMember> predicate) {
        return Optional.of(person)
                .map(Person::getFamilyMembers)
                .orElse(Collections.emptyList()).stream()
                .filter(predicate)
                .map(FamilyMember::getName)
                .collect(Collectors.toList());
    }
}