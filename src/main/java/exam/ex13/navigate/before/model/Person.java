package exam.ex13.navigate.before.model;

import java.util.Collection;

import lombok.Data;

@Data
public class Person {

    private String name;
    private Gender gender;
    private ContactInfo contactInfo;
    private Collection<FamilyMember> familyMembers;
}