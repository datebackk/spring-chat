package api.dto;

import lombok.Data;
import model.model.Role;

import java.util.List;

@Data
public class UserResponseDTO {
    private Long id;
    private String email;
    List<Role> roles;
}
