package j2ee_major.ptud.repository;

import j2ee_major.ptud.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
