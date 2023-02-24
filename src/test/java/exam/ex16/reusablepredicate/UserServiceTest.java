package exam.ex16.reusablepredicate;

import exam.ex16.reusablepredicate.functional.UserDto;
import exam.ex16.reusablepredicate.functional.UserService;
import exam.ex16.reusablepredicate.functional.UserVOMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private GlobalIdentityService identityService;

    private UserService subject;

    @BeforeEach
    void setUp(){
        subject = new UserService(identityService, new UserVOMapper());
    }

    @Nested
    @DisplayName("Given getUserVO() is called...")
    class GivenGetUserVOIsCalled {
        final String viewerIdentity = UUID.randomUUID().toString();
        final String editorIdentity = UUID.randomUUID().toString();
        final String adminIdentity = UUID.randomUUID().toString();

        @Test
        @DisplayName("when the UserDto is a viewer type, UserVO with the expected identity returns.")
        void whenTheUserDtoIsAViewerTypeUserVOWithTheExpectedIdentityReturns(){
            final String userId = UUID.randomUUID().toString();
            when(identityService.getViewerIdentity(userId)).thenReturn(viewerIdentity);
            final UserVO result = subject.getUserVO(UserDto.builder().Id(userId).authType(AuthType.VIEWER).build());

            assertThat(result.getIdentity()).isEqualTo(viewerIdentity);
        }

        @Test
        @DisplayName("when the UserDto is a editor type, UserVO with the expected identity returns.")
        void whenTheUserDtoIsAEditorTypeUserVOWithTheExpectedIdentityReturns(){
            final String userId = UUID.randomUUID().toString();
            when(identityService.getEditorIdentity(userId)).thenReturn(editorIdentity);
            final UserVO result = subject.getUserVO(UserDto.builder().Id(userId).authType(AuthType.EDITOR).build());

            assertThat(result.getIdentity()).isEqualTo(editorIdentity);
        }

        @Test
        @DisplayName("when the UserDto is a admin type, UserVO with the expected identity returns.")
        void whenTheUserDtoIsAAdminTypeUserVOWithTheExpectedIdentityReturns(){
            final String userId = UUID.randomUUID().toString();
            when(identityService.getAdminIdentity(userId)).thenReturn(adminIdentity);
            final UserVO result = subject.getUserVO(UserDto.builder().Id(userId).authType(AuthType.ADMIN).build());

            assertThat(result.getIdentity()).isEqualTo(adminIdentity);
        }
    }
}
