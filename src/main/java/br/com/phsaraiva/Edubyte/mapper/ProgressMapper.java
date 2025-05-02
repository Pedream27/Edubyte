package br.com.phsaraiva.Edubyte.mapper;

import br.com.phsaraiva.Edubyte.dto.LessonDTO;
import br.com.phsaraiva.Edubyte.dto.ProgressDTO;
import br.com.phsaraiva.Edubyte.model.Lesson;
import br.com.phsaraiva.Edubyte.model.Progress;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgressMapper {

    ProgressDTO progressToProgressDTO(Progress course);

    Progress progressDTOToProgress(ProgressDTO progressDTO);
}
