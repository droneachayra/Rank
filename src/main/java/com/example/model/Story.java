package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private int score;
    private LocalDateTime submissionTime;
    private String submitterUsername;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public LocalDateTime getSubmissionTime() {
		return submissionTime;
	}
	public void setSubmissionTime(LocalDateTime submissionTime) {
		this.submissionTime = submissionTime;
	}
	public String getSubmitterUsername() {
		return submitterUsername;
	}
	public void setSubmitterUsername(String submitterUsername) {
		this.submitterUsername = submitterUsername;
	}
	@Override
	public String toString() {
		return "Story [id=" + id + ", title=" + title + ", url=" + url + ", score=" + score + ", submissionTime="
				+ submissionTime + ", submitterUsername=" + submitterUsername + "]";
	}
    
}