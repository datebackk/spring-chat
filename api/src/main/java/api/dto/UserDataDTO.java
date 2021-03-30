package api.dto;


import lombok.Data;
import model.model.Role;


import java.util.List;

@Data
public class UserDataDTO {

    private String email;

    private String password;

    List<Role> roles;
}
