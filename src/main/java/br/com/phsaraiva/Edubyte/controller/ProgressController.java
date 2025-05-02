package br.com.phsaraiva.Edubyte.controller;

import br.com.phsaraiva.Edubyte.dto.ProgressDTO;
import br.com.phsaraiva.Edubyte.model.User;
import br.com.phsaraiva.Edubyte.service.ProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/progress")
public class ProgressController {


    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    @PostMapping("/{lessonId}")
    public ResponseEntity<?> updateProgress(@PathVariable Long lessonId, @RequestBody ProgressDTO dto, @AuthenticationPrincipal User user) {
        progressService.updateProgress(user.getId(), lessonId, dto);
        return ResponseEntity.ok().build();
    }
}