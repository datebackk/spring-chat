package service.service;

import model.model.User;

import java.util.List;

public interface UserService {
    List<User> findByNicknameIgnoreCaseContains(String nickname);

    User findByEmail(String email);

    void save(User user);
}
