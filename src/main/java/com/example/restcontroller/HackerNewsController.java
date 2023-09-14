package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Comment;
import com.example.model.Story;
import com.example.service.HackerNewsService;

@RestController
@RequestMapping("/api")
public class HackerNewsController {

    @Autowired
    private HackerNewsService hackerNewsService;

    @GetMapping("/top-stories")
    public ResponseEntity<List<Story>> getTopStories() {
        List<Story> topStories = hackerNewsService.getTopStories();
        return ResponseEntity.ok(topStories);
    }

    @GetMapping("/past-stories")
    public ResponseEntity<List<Story>> getPastStories() {
        List<Story> pastStories = hackerNewsService.getPastStories();
        return ResponseEntity.ok(pastStories);
    }

    @GetMapping("/comments")
    public ResponseEntity<List<Comment>> getComments(@RequestParam Long storyId) {
        List<Comment> comments = hackerNewsService.getComments(storyId);
        return ResponseEntity.ok(comments);
    }
}
