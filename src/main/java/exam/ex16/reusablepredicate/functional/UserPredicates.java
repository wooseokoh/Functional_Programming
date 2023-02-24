package exam.ex16.reusablepredicate.functional;

import java.util.function.Predicate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class UserPredicates {

    public static final Predicate<UserDto> IS_VIEWER = userDto -> {
        log.debug("trying isViewer...");
        return userDto.isViewer();
    };
    public static final Predicate<UserDto> Is_EDITOR = userDto -> {
        log.debug("trying isEditor...");
        return userDto.isEditor();
    };
    public static final Predicate<UserDto> IS_ADMIN = userDto -> {
        log.debug("trying isAdmin...");
        return userDto.isAdmin();
    };
}