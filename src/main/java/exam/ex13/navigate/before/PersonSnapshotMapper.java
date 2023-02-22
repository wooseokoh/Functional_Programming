package exam.ex13.navigate.before;

import exam.ex13.navigate.before.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PersonSnapshotMapper {

    public PersonSnapshot map(Person person) {
        return PersonSnapshot.builder()
                .name(person.getName())
                .homeNumber(getHomeNumber(person))
                .mobileNumber(getMobileNumber(person))
                .dependentNames(getDependentNames(person))
                .siblingNames(getSiblingNames(person))
                .build();
    }

    private String getHomeNumber(Person person) {
        return getPhoneNumber(person, PhoneType.HOME);
    }

    private String getMobileNumber(Person person) {
        return getPhoneNumber(person, PhoneType.MOBILE);
    }

    private String getPhoneNumber(Person person, PhoneType phoneType) {
        final ContactInfo contactInfo = person.getContactInfo();
        if (contactInfo != null) {
            final Collection<Telephone> phoneNumbers = contactInfo.getPhoneNumbers();
            if (phoneNumbers != null) {
                for (Telephone phoneNumber : phoneNumbers) {
                    if (phoneNumber.getPhoneType() == phoneType) {
                        return phoneNumber.getAreaCode() + phoneNumber.getNumber();
                    }
                }
            }
        }
        return null;
    }

    private String getDependentNames(Person person) {
        final List<String> result = new ArrayList<>();
        final Collection<FamilyMember> familyMembers = person.getFamilyMembers();
        if (familyMembers != null) {
            for (FamilyMember familyMember : familyMembers) {
                if (familyMember.isDependent()) {
                    result.add(familyMember.getName());
                }
            }
        }
        return String.join(",", result);
    }

    private String getSiblingNames(Person person) {
        final List<String> result = new ArrayList<>();
        final Collection<FamilyMember> familyMembers = person.getFamilyMembers();
        if (familyMembers != null) {
            for (FamilyMember familyMember : familyMembers) {
                if (familyMember.getRelationType() == RelationType.SIBLING) {
                    result.add(familyMember.getName());
                }
            }
        }
        return String.join(",", result);
    }
}