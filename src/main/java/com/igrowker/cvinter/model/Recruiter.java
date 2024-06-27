package com.igrowker.cvinter.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

public class Recruiter {
    @Id
    private int id;
    private String email;
    private String fullName;
    private List<Long> scheduledCalls;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Recruiter(int id, String email, String fullName, List<Long> scheduledCalls, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.scheduledCalls = scheduledCalls;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Recruiter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Long> getScheduledCalls() {
        return scheduledCalls;
    }

    public void setScheduledCalls(List<Long> scheduledCalls) {
        this.scheduledCalls = scheduledCalls;
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
        return "Recruiter{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", scheduledCalls=" + scheduledCalls +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
