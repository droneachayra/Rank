package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Comment;
import com.example.model.Story;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	 List<Comment> findByStory(Story story);
}
