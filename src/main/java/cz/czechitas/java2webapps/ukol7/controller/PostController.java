package cz.czechitas.java2webapps.ukol7.controller;

import cz.czechitas.java2webapps.ukol7.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import cz.czechitas.java2webapps.ukol7.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;

@Controller
@RequestMapping("")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("")
    public ModelAndView newestPosts(@PageableDefault(size = 5, page = 0) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Post> posts = postService.getPostsOrderByPublished(pageable);
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @GetMapping("/{slug}")
    public ModelAndView detail(@PathVariable String slug) {
        ModelAndView modelAndView = new ModelAndView("article");
        modelAndView.addObject("post", postService.singlePost(slug));
        return modelAndView;
    }
}