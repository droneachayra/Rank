package com.example.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private String hackerNewsHandle;
    private LocalDateTime submissionTime;
    @ManyToOne
    @JoinColumn(name = "story_id")
    private Story story;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHackerNewsHandle() {
		return hackerNewsHandle;
	}
	public void setHackerNewsHandle(String hackerNewsHandle) {
		this.hackerNewsHandle = hackerNewsHandle;
	}
	public LocalDateTime getSubmissionTime() {
		return submissionTime;
	}
	public void setSubmissionTime(LocalDateTime submissionTime) {
		this.submissionTime = submissionTime;
	}
	public Story getStory() {
		return story;
	}
	public void setStory(Story story) {
		this.story = story;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", hackerNewsHandle=" + hackerNewsHandle + ", submissionTime="
				+ submissionTime + ", story=" + story + "]";
	}
    
    
}