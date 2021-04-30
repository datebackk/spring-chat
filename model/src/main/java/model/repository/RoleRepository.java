package model.repository;

import model.model.Role;
import model.model.RoleName;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, RoleName> {
    Optional<Role> findByName(RoleName name);
}
