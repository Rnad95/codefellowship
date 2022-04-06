package com.example.Repositories;

import com.example.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    Post findAllById(int Id);
    Set<Post> findAll();
}
