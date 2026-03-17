package j2ee_major.ptud.controller;

import j2ee_major.ptud.model.Course;
import j2ee_major.ptud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public String home(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Course> coursePage = courseService.getCourses(page);

        model.addAttribute("coursePage", coursePage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", coursePage.getTotalPages());

        return "home";
    }
}
