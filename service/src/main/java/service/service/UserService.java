package service.service;

import model.model.User;

import java.util.List;

public interface UserService {
    List<User> findByNicknameContains(String nickname);
}
