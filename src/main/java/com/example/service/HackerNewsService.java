package com.example.service;

import java.util.List;

import com.example.model.Comment;
import com.example.model.Story;

public interface HackerNewsService {

	public List<Story> getPastStories();

	public List<Story> getTopStories();

	public List<Comment> getComments(Long storyId);

}
