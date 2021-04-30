package service.serviceImpl;

import lombok.RequiredArgsConstructor;
import model.model.Role;
import model.model.RoleName;
import model.repository.RoleRepository;
import org.springframework.stereotype.Service;
import service.service.RoleService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
