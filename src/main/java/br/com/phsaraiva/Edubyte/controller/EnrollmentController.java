package br.com.phsaraiva.Edubyte.controller;

import br.com.phsaraiva.Edubyte.model.User;
import br.com.phsaraiva.Edubyte.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/enroll")
    public class EnrollmentController {


        private final EnrollmentService enrollmentService;

        public EnrollmentController(EnrollmentService enrollmentService) {
            this.enrollmentService = enrollmentService;
        }

        @PostMapping("/{courseId}")
        public ResponseEntity<?> enroll(@PathVariable Long courseId, @AuthenticationPrincipal User user) {
            enrollmentService.enrollUserInCourse(user.getId(), courseId);
            return ResponseEntity.ok().build();
        }
    }

}
