package exam.ex13.navigate.functional.model;

import lombok.Data;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
public class Person {

    private String name;
    private Gender gender;
    private ContactInfo contactInfo;
    private Collection<FamilyMember> familyMembers;

    public Optional<String> getPhoneNumber(PhoneType phoneType) {
        return Optional.ofNullable(contactInfo)
                .map(ContactInfo::getTelephones)
                .flatMap(telephones -> findTelphone(telephones, phoneType))
                .map(Telephone::completeNumber);
    }

    private static Optional<Telephone> findTelphone(Collection<Telephone> telephones, PhoneType phoneType){
        return telephones.stream()
                .filter(telephone -> telephone.isTypeOf(phoneType))
                .findAny();
    }

    public Collection<FamilyMember> getDependents(){
        return getFamilyMembers().stream()
                .filter(FamilyMember::isDependent)
                .collect(Collectors.toList());
    }

    public Collection<FamilyMember> getSiblings(){
        return getFamilyMembers().stream()
                .filter(FamilyMember::isSibling)
                .collect(Collectors.toList());
    }

    public Collection<FamilyMember> getFamilyMembers(){
        return CollectionUtils.emptyIfNull(this.familyMembers);
    }

    public boolean isMale(){
        return this.gender == Gender.MALE;
    }

    public boolean isFemale(){
        return this.gender == Gender.FEMAIL;
    }
}