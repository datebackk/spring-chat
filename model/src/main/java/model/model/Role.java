package model.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role")
public class Role {
    @Id
    private Long id;
    private String name;
}
