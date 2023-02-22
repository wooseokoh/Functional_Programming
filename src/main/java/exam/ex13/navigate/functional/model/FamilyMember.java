package exam.ex13.navigate.functional.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
@EqualsAndHashCode(callSuper = true)
public
class FamilyMember extends Person {

    private RelationType relationType;
    private boolean dependent;

    public boolean hasRelationOf(RelationType relationType) {
        return this.relationType == relationType;
    }

    public boolean isParent() {
        return this.hasRelationOf(RelationType.PARENT);
    }

    public boolean isChild() {
        return this.hasRelationOf(RelationType.CHILD);
    }

    public boolean isSibling() {
        return this.hasRelationOf(RelationType.SIBLING);
    }

    public Collection<FamilyMember> siblings(){
        return familyMember(FamilyMember::isSibling);
    }

    private Collection<FamilyMember> familyMember(Predicate<FamilyMember> familyMemberPredicate){
        return getFamilyMembers().stream()
                .filter(familyMemberPredicate)
                .collect(Collectors.toList());
    }

    public Collection<FamilyMember> children(){
        return familyMember(FamilyMember::isChild);
    }
}