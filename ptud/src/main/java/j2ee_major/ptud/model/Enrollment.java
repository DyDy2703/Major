package j2ee_major.ptud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "enrollment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @NotNull(message = "Ngày đăng ký không được để trống")
    private LocalDate enrollDate;
}