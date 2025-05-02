package br.com.phsaraiva.Edubyte.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Progress {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Lesson lesson;

    private boolean completed;
    private int currentTimestamp; //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getCurrentTimestamp() {
        return currentTimestamp;
    }

    public void setCurrentTimestamp(int currentTimestamp) {
        this.currentTimestamp = currentTimestamp;
    }
}
