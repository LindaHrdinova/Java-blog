package cz.czechitas.java2webapps.ukol7.service;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import cz.czechitas.java2webapps.ukol7.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {


    
    public List<Post> findAll() {
        return postRepository.findAll();
    }

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getPostsOrderByPublished(Pageable pageable) {
        LocalDate today = LocalDate.now();
        return postRepository.findByPublishedBeforeOrderByPublishedDesc(today, pageable);
    }


    public Post singlePost(String slug) {
        return postRepository.findBySlug(slug);
    }
}
