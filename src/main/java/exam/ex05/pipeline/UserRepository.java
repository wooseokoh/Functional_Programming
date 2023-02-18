package exam.ex05.pipeline;

import exam.ex05.pipeline.model.User;

public interface UserRepository {
    User findByUsername(String username);
}
