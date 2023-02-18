package exam.ex05.pipeline;

import exam.ex05.pipeline.model.User;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final IdentifierMapper identifierMapper;
    private final AuditLogger auditLogger;

    public Identifier getIdentifierMapper(String username){
        final User user = userRepository.findByUsername(username);
        final Identifier identifier = identifierMapper.map(user);
        auditLogger.log(identifier);
        return identifier;
    }

}
