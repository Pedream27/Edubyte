# 🎓 Course Stream API

Uma API RESTful para uma plataforma de cursos com estilo inspirado no Stremio. Desenvolvida com Java, Spring Boot e autenticação via JWT.


## 🚀 Funcionalidades

- Algumas funcinalidades ainda estão em desenvolvimento 
- 📚 Listar cursos e detalhes
- 🎮 Listar aulas por curso
- ✅ Matricular-se em cursos
- 📈 Atualizar progresso por aula
- ⭐ Favoritar cursos
- 🔐 Autenticação e autorização com JWT

## 🔗 Endpoints

### Cursos
- `GET /courses` – Lista todos os cursos
- `GET /courses/{id}` – Detalhes de um curso
- `GET /courses/{id}/lessons` – Lista de aulas de um curso

### Matrícula
- `POST /enroll/{courseId}` – Matricular-se em um curso (necessita autenticação)

### Progresso
- `POST /progress/{lessonId}` – Atualizar progresso de uma aula (necessita autenticação)

### Favoritos
- `GET /favorite/user/favorites` – Listar cursos favoritos (necessita autenticação)
- `POST /favorite/{courseId}` – Favoritar um curso (necessita autenticação)

### Autenticação
- `POST /login` – Gerar token JWT
- `POST /register` – Cadastrar novo usuário

## 🔐 Segurança

- JWT Token para autenticação
- Acesso público apenas para:
  - `/courses/**`
  - `/login`
  - `/register`
- Acesso autenticado para todos os outros endpoints

## 💠 Tecnologias

- Java 17+
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- H2 Database (para testes)
- MockMvc (para testes de controller)
- Docker & Docker Compose

🐳 Docker
Este projeto já está pronto para rodar com Docker e Docker Compose.

Dockerfile
Dockerfile
Copiar
Editar
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/course-stream-api.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
docker-compose.yml
yaml
Copiar
Editar
version: "3.8"

services:
  app:
    build: .
    container_name: course-stream-api
    ports:
      - "8080:8080"
    environment:
      - SPRING_PROFILES_ACTIVE=prod
    depends_on:
      - db

  db:
    image: postgres:16
    container_name: course-stream-db
    environment:
      POSTGRES_DB: banco_de_dados_postgres
      POSTGRES_USER: usuario_postgres
      POSTGRES_PASSWORD: senha_postgres
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

volumes:
  pgdata:
Para iniciar
bash
Copiar
Editar
docker-compose up --build
Acesse a API em http://localhost:8080.

## 🧪 Testes

Exemplo com MockMvc:

```java
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
               .andExpect(jsonPath("$[0].title").value("Java"));
    }
}
```

## 📁 Estrutura

- `controller/` – Controladores REST
- `service/` – Lógica de negócios
- `config/` – Configurações de segurança
- `dto/` – Transferência de dados
- `filter/` – Filtro JWT
- `test/` – Testes unitários

## ✉️ Autenticação

O header de autenticação JWT deve ser enviado como:

```
Authorization: Bearer <token>
```
