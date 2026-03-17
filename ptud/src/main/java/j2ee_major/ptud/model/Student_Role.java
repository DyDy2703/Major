package j2ee_major.ptud.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@IdClass(StudentRoleId.class)
public class Student_Role {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
}