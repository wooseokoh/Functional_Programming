package exam.ex16.reusablepredicate.functional;

import exam.ex16.reusablepredicate.AuthType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String Id;
    private AuthType authType;

    public boolean isViewer() {
        return authType == AuthType.VIEWER;
    }
    public boolean isEditor() {
        return authType == AuthType.EDITOR;
    }
    public boolean isAdmin() {
        return authType == AuthType.ADMIN;
    }
}