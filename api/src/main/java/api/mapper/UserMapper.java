package api.mapper;

import api.dto.UserDTO;
import model.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);

    List<UserDTO> listToDTO(List<User> user);

    void mergeWith(UserDTO userDTO, @MappingTarget User user);
}
