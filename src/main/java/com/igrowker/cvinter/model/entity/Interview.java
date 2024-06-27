package com.igrowker.cvinter.model.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "interviews")
public class Interview {
    @Id
    private long id;
    private int userId;
    private String videoURL;
    private List<Question> questions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Interview(int id, int userId, String videoURL, List<Question> questions, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.videoURL = videoURL;
        this.questions = questions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Interview() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Interview{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoURL='" + videoURL + '\'' +
                ", questions=" + questions +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
