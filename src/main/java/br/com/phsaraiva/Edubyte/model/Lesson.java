package br.com.phsaraiva.Edubyte.model;

import jakarta.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String videoUrl;
    private Integer durationInMinutes;

    @ManyToOne
    private Course course;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Integer getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(Integer durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
