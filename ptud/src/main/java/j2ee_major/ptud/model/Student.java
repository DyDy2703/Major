package j2ee_major.ptud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "Username không được để trống")
    private String username;

    @NotBlank(message = "Password không được để trống")
    private String password;

    @Email(message = "Email không hợp lệ")
    private String email;

    @ManyToMany
    @JoinTable(
            name = "student_role",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles;
}