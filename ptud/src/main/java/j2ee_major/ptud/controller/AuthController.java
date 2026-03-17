package j2ee_major.ptud.controller;

import j2ee_major.ptud.model.Role;
import j2ee_major.ptud.model.Student;
import j2ee_major.ptud.repository.RoleRepository;
import j2ee_major.ptud.repository.StudentRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class AuthController {

    private final StudentRepository studentRepository;
    private final RoleRepository roleRepository;

    public AuthController(StudentRepository studentRepository,
                          RoleRepository roleRepository) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }

    // Hiển thị form
    @GetMapping
    public String showRegisterForm(Model model) {
        model.addAttribute("student", new Student());
        return "auth/register";
    }

    // Xử lý đăng ký
    @PostMapping
    public String register(@ModelAttribute Student student) {

        // 🔥 Gán role STUDENT
        Role role = roleRepository.findByName("STUDENT")
                .orElseThrow(() -> new RuntimeException("Role not found"));

//        student.setRole(role);

        studentRepository.save(student);

        return "redirect:/";
    }
}
