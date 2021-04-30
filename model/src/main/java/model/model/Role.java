package model.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    @Enumerated(EnumType.ORDINAL)
    private RoleName name;
}
