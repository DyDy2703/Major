package j2ee_major.ptud.repository;

import j2ee_major.ptud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}