package model.repository;

import model.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    User findByEmail(String email);

    List<User> findByNicknameIgnoreCaseContains(String nickname);

    @Transactional
    void deleteByEmail(String email);
}
