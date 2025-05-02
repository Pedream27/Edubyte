package br.com.phsaraiva.Edubyte;

import br.com.phsaraiva.Edubyte.controller.CourseController;
import br.com.phsaraiva.Edubyte.dto.CourseDTO;
import br.com.phsaraiva.Edubyte.service.CourseService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.List;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
public class CourseControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseService courseService;

    @Test
    public void shouldReturnListOfCourses() throws Exception {
        List<CourseDTO> courses = List.of(new CourseDTO("Java", "Curso de Java"));
        Mockito.when(courseService.getAllCourses()).thenReturn(courses);

        mockMvc.perform(get("/courses"))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$[0].title").value("Java"));
    }
}
