package com.example.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    // You can define custom query methods here if needed
}
