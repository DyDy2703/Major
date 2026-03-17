package j2ee_major.ptud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên khóa học không được để trống")
    private String name;

    private String image;

    @NotNull(message = "Credits không được để trống")
    @Min(value = 1, message = "Credits phải > 0")
    private Integer credits;

    @NotBlank(message = "Giảng viên không được để trống")
    private String lecturer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}