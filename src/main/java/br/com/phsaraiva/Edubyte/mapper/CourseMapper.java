package br.com.phsaraiva.Edubyte.mapper;

import br.com.phsaraiva.Edubyte.dto.CourseDTO;
import br.com.phsaraiva.Edubyte.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    // Mapeia de Course para CourseDTO
    CourseDTO courseToCourseDTO(Course course);

    // Mapeia de CourseDTO para Course
    Course courseDTOToCourse(CourseDTO courseDTO);

}
