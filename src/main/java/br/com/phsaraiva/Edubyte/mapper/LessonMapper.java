package br.com.phsaraiva.Edubyte.mapper;

import br.com.phsaraiva.Edubyte.dto.LessonDTO;
import br.com.phsaraiva.Edubyte.model.Lesson;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LessonMapper {

    LessonDTO lessonToLessonDTO(Lesson course);

    Lesson lessonDTOToLesson(LessonDTO lessonDTO);
}
