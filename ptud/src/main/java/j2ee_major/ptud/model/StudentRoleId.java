package j2ee_major.ptud.model;

import java.io.Serializable;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRoleId implements Serializable {
    private Long student;
    private Long role;
}