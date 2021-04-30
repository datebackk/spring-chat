package service.serviceImpl;

import lombok.RequiredArgsConstructor;
import model.model.User;
import model.repository.UserRepository;
import org.springframework.stereotype.Service;
import service.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findByNicknameIgnoreCaseContains(String nickname) {
        return userRepository.findByNicknameIgnoreCaseContains(nickname);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
