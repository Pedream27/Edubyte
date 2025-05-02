package br.com.phsaraiva.Edubyte.model;

import jakarta.persistence.*;

@Entity
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Course course;
}

}
