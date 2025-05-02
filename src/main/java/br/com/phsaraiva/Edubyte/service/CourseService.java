package br.com.phsaraiva.Edubyte.service;

import br.com.phsaraiva.Edubyte.dto.CourseDTO;
import br.com.phsaraiva.Edubyte.dto.LessonDTO;
import br.com.phsaraiva.Edubyte.mapper.CourseMapper;
import br.com.phsaraiva.Edubyte.mapper.LessonMapper;
import br.com.phsaraiva.Edubyte.model.Course;
import br.com.phsaraiva.Edubyte.repository.CourseRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final LessonMapper lessonMapper;

    public CourseService(CourseRepository courseRepository, CourseMapper courseMapper, LessonMapper lessonMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.lessonMapper = lessonMapper;
    }

    public List<CourseDTO> getAllCourses() {
        var list =  courseRepository.findAll();
        List<CourseDTO> convertList  = List.of();
        list.stream().forEach(course -> convertList.add(courseMapper.courseToCourseDTO(course)));
        return  convertList;
    }

    public CourseDTO getCourseById(Long id) throws Exception {
    var curso =  courseRepository.findById(id).orElseThrow(() -> new Exception("Curso não encontrado"));
        return courseMapper.courseToCourseDTO(curso);
    }

    public List<LessonDTO> getLessonsByCourse(Long courseId) throws Exception {
        var course = courseRepository.findById(courseId).orElseThrow(() -> new Exception("Curso não encontrado"));
        var lessons = course.getLessons();
        List<LessonDTO> convertLessons = List.of();
        lessons.stream().forEach(lesson -> convertLessons.add(lessonMapper.lessonToLessonDTO(lesson)));
        return convertLessons;
    }
}