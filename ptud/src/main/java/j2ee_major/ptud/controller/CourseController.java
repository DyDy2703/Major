package j2ee_major.ptud.controller;

import j2ee_major.ptud.model.Course;
import j2ee_major.ptud.repository.CategoryRepository;
import j2ee_major.ptud.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/course")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    // 👉 Hiển thị form thêm
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("course", new Course());
//        model.addAttribute("categories", categoryRepository.findAll());
        return "course/add-course";
    }

    // 👉 Lưu (thêm + sửa)
    @PostMapping("/add")
    public String saveCourse(@ModelAttribute Course course) {
        courseRepository.save(course);
        return "redirect:/";
    }

    // 👉 Sửa
    @GetMapping("/edit/{id}")
    public String editCourse(@PathVariable Long id, Model model) {
        Course course = courseRepository.findById(id).orElseThrow();
        model.addAttribute("course", course);
        model.addAttribute("categories", categoryRepository.findAll());
        return "course/edit-course";
    }

    @PostMapping("/edit/{id}")
    public String updateCourse(@PathVariable Long id, @ModelAttribute Course course) {
//        course.setId(id);
        courseRepository.save(course);
        return "redirect:/";
    }

    // 👉 Xóa
    @GetMapping("/delete/{id}")
    public String deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return "redirect:/";
    }
}
