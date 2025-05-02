package br.com.phsaraiva.Edubyte.service;

import br.com.phsaraiva.Edubyte.dto.CourseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    public void favoriteCourse(Long userId, Long courseId) {
        // lógica de favoritar
    }

    public List<CourseDTO> getUserFavorites(Long userId) {
        // lógica de listar favoritos
        return List.of();
    }
}

