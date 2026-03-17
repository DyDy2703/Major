package j2ee_major.ptud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.relational.core.mapping.Table;


@Entity
@Table(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @NotBlank(message = "Tên role không được để trống")
    private String name; // ADMIN, STUDENT
}