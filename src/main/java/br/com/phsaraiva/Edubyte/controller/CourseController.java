package br.com.phsaraiva.Edubyte.controller;

import br.com.phsaraiva.Edubyte.dto.CourseDTO;
import br.com.phsaraiva.Edubyte.dto.LessonDTO;
import br.com.phsaraiva.Edubyte.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class CourseController {

    private final  CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> listCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable Long id) throws Exception {
             return courseService.getCourseById(id);
    }

    @GetMapping("/{id}/lessons")
    public List<LessonDTO> listLessons(@PathVariable Long id) throws Exception {
        return courseService.getLessonsByCourse(id);
    }
}
