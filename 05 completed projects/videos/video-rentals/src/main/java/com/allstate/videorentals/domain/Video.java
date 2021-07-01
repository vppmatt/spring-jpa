package com.allstate.videorentals.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;

    private String title;
    private String genre;
    private Integer runningTime;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRunningTime() {
        return runningTime;
    }

    public void setRunningTime(Integer runningTime) {
        this.runningTime = runningTime;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Video{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", runningTime=" + runningTime +
                ", comments=" + comments +
                '}';
    }
}
