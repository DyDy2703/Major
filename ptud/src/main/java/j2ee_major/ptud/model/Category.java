package j2ee_major.ptud.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tên category không được để trống")
    private String name;
}
