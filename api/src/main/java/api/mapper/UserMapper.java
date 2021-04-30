package api.mapper;

import api.dto.UserDTO;
import model.model.User;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDTO(User user);

    List<UserDTO> listToDTO(List<User> user);

    void mergeWith(UserDTO userDTO, @MappingTarget User user);
}
