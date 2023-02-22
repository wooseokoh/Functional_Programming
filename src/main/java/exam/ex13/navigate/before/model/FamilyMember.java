package exam.ex13.navigate.before.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public
class FamilyMember extends Person {

    private RelationType relationType;
    private boolean dependent;
}