package exam.ex16.reusablepredicate.functional;

import exam.ex16.reusablepredicate.GlobalIdentityService;
import exam.ex16.reusablepredicate.UserVO;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static exam.ex16.reusablepredicate.functional.UserPredicates.*;

@RequiredArgsConstructor
public class UserService {

    private final GlobalIdentityService identityService;
    private final UserVOMapper userVOMapper;

    private Map<Predicate<UserDto>, Function<String, String>> identityFunctions;

    public UserVO getUserVO(UserDto userDto){
        return userVOMapper.map(userDto, getIdentityFunctions());
    }

    private Map<Predicate<UserDto>, Function<String, String>>  getIdentityFunctions(){
            this.identityFunctions =Optional.ofNullable(this.identityFunctions)
                .orElseGet(() -> Map.of(
                    IS_VIEWER, identityService::getViewerIdentity,
                    Is_EDITOR, identityService::getEditorIdentity,
                    IS_ADMIN, identityService::getAdminIdentity));
            return this.identityFunctions;
    }
}
