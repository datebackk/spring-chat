package api.dto;

import lombok.Data;
import model.model.Role;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private List<Role> roles;
}
