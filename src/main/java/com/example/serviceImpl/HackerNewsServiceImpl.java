package com.example.serviceImpl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import  java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.Comment;
import com.example.model.HNStoryDetail;
import com.example.model.HNStoryResponse;
import com.example.model.Story;
import com.example.service.HackerNewsService;


@Service
public class HackerNewsServiceImpl implements HackerNewsService {

    @Autowired
    private RestTemplate restTemplate;
    

    @Override
    @Cacheable(value = "topStories", key = "'top-stories'")
    public List<Story> getTopStories() {
        // Fetch data from Hacker News API
        ResponseEntity<HNStoryResponse> response = restTemplate.exchange(
            "https://hacker-news.firebaseio.com/v0/topstories.json",
            HttpMethod.GET,
            null,
            HNStoryResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK) {
            List<HNStoryResponse> storyIds = Arrays.asList(response.getBody());
            List<Story> topStories = new ArrayList<>();

            // Fetch details for each story
            for (HNStoryResponse storyId : storyIds.subList(0, Math.min(10, storyIds.size()))) {
                ResponseEntity<HNStoryDetail> storyDetailResponse = restTemplate.exchange(
                    "https://hacker-news.firebaseio.com/v0/item/" + storyId + ".json",
                    HttpMethod.GET,
                    null,
                    HNStoryDetail.class
                );

                if (storyDetailResponse.getStatusCode() == HttpStatus.OK) {
                    HNStoryDetail storyDetail = storyDetailResponse.getBody();
                    Story story = new Story();
                    story.setTitle(storyDetail.getTitle());
                    story.setUrl(storyDetail.getUrl());
                    story.setScore(storyDetail.getScore());
                    story.setSubmissionTime(LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(storyDetail.getTime()), ZoneId.systemDefault()));
                    story.setSubmitterUsername(storyDetail.getBy());
                    topStories.add(story);
                }
            }

            return topStories;
        } else {
            throw new RuntimeException("Failed to fetch top stories from Hacker News API");
        }
    }

    @Override
    @Cacheable(value = "pastStories", key = "'past-stories'")
    public List<Story> getPastStories() {
        // This method can return the cached data from the "topStories" cache.
        // You can customize this logic based on your requirements.
        return getTopStories();
    }

    @Override
    @Cacheable(value = "comments", key = "'comments-' + #storyId")
    public List<Comment> getComments(Long storyId) {
        // Fetch comments for a given story from Hacker News API
        // Implement this logic based on the Hacker News API structure
        // Example: Fetch comments for a story with ID storyId
        // Example URL: "https://hacker-news.firebaseio.com/v0/item/" + storyId + ".json"

        // You can map the API response to your Comment entity and return it
        // Example: Comment comment = mapAPIDataToComment(response.getBody());

        // Return a list of comments (up to 10 comments) sorted by the total number of child comments
        // You can sort the comments using Java stream operations

        // Be sure to handle exceptions and error cases appropriately
        return new ArrayList<>(); // Replace with your implementation
    }
}
