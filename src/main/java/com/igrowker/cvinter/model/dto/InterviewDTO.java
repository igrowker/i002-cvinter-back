package com.igrowker.cvinter.model.dto;

import com.igrowker.cvinter.model.entity.Question;

import java.time.LocalDateTime;
import java.util.List;

public class InterviewDTO {

    private long id;
    private int userId;
    private String videoURL;
    private List<Question> questions;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public InterviewDTO() {
    }

    public InterviewDTO(long id, int userId, String videoURL, List<Question> questions, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.videoURL = videoURL;
        this.questions = questions;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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
        return "InterviewDTO{" +
                "id=" + id +
                ", userId=" + userId +
                ", videoURL='" + videoURL + '\'' +
                ", questions=" + questions +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
