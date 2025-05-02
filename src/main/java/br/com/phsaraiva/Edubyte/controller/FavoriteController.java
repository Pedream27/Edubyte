package br.com.phsaraiva.Edubyte.controller;

import br.com.phsaraiva.Edubyte.dto.CourseDTO;
import br.com.phsaraiva.Edubyte.model.User;
import br.com.phsaraiva.Edubyte.service.FavoriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorite")
public class FavoriteController {


    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @PostMapping("/{courseId}")
    public ResponseEntity<?> addFavorite(@PathVariable Long courseId, @AuthenticationPrincipal User user) {
        favoriteService.favoriteCourse(user.getId(), courseId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/user/favorites")
    public List<CourseDTO> listFavorites(@AuthenticationPrincipal User user) {
        return favoriteService.getUserFavorites(user.getId());
    }
}