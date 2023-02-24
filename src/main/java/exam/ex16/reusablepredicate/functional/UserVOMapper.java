package exam.ex16.reusablepredicate.functional;

import exam.ex16.reusablepredicate.UserVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

@RequiredArgsConstructor
@Slf4j
public class UserVOMapper {

    public UserVO map(UserDto userDto, Map<Predicate<exam.ex16.reusablepredicate.functional.UserDto>, Function<String, String>> identityPredicates) {
        log.debug("** Starting to map UserDto th UserVO");

        return UserVO.builder()
                .identity(getIdentity(userDto, identityPredicates))
                .build();
    }

    private String getIdentity(UserDto userDto, Map<Predicate<exam.ex16.reusablepredicate.functional.UserDto>, Function<String, String>> identityPredicates) {
        return identityPredicates.entrySet().stream()
                .filter(entry -> entry.getKey().test(userDto))
                .findFirst()
                .map(entry -> entry.getValue().apply(userDto.getId()))
                .orElseThrow(() -> new RuntimeException("Failed to get the identity of User: " + userDto));
    }

}