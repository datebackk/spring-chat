package service.service;

import model.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findById(Long id);
}
