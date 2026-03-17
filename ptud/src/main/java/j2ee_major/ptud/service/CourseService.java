package j2ee_major.ptud.service;

import j2ee_major.ptud.model.Course;
import j2ee_major.ptud.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.PageRequest;
        import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Page<Course> getCourses(int page) {
        return courseRepository.findAll(PageRequest.of(page, 5));
    }
}