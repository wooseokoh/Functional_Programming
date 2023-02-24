package exam.ex16.reusablepredicate.flaw;

import exam.ex16.reusablepredicate.AuthType;
import lombok.Data;

@Data
public class UserDto {

    private String userId;
    private AuthType authType;
}