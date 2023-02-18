package exam.ex05.pipeline;

import java.util.function.Function;
import java.util.function.UnaryOperator;

import exam.ex05.pipeline.model.User;
import lombok.RequiredArgsConstructor;
// 가독성 향상, 재사용성 향상
@RequiredArgsConstructor
public class Solution {

    private final UserRepository userRepository;
    private final IdentifierMapper identifierMapper;
    private final AuditLogger auditLogger;

    // final method
    public final Function<String, User> findByUsername(){
        return userRepository::findByUsername;
    }
    public final Function<User, Identifier> getIdentifier(){
        return identifierMapper::map;
    }
    public final UnaryOperator<Identifier> logIt(){
        return value -> {
            auditLogger.log(value);
            return value;
        };
    };

    // function pipelined
    public Identifier getIdentifierMapper(String username) {
        return findByUsername()
                .andThen(getIdentifier())
                .andThen(logIt())
                .apply(username);
    }
}