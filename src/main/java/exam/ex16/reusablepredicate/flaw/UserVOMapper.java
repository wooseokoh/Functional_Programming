package exam.ex16.reusablepredicate.flaw;

import exam.ex16.reusablepredicate.AuthType;
import exam.ex16.reusablepredicate.GlobalIdentityService;
import exam.ex16.reusablepredicate.UserVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserVOMapper {

    private final GlobalIdentityService identityService;

    public UserVO map(UserDto userDto){
        return UserVO.builder()
                .identity(getIdentity(userDto.getUserId(), userDto.getAuthType()))
                .build();
    }

    private String getIdentity(String userId, AuthType authType){
        return switch (authType){
            case VIEWER -> identityService.getViewerIdentity(userId);
            case EDITOR -> identityService.getEditorIdentity(userId);
            case ADMIN ->  identityService.getAdminIdentity(userId);

        };
    }
}
