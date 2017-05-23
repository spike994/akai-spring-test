package com.akai.resources;

import com.akai.model.Blog;
import com.akai.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by martwy_kotek on 23.05.2017.
 */
@RestController
@RequestMapping("/api/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/add")
    public void create(@RequestBody Blog blog){
        blogService.addBlog(blog);
    }

    @GetMapping
    public List<Blog> getAll(){
        return blogService.getAll();
    }

    @GetMapping("/{path}")
    public Blog get(@PathVariable String path){
        return blogService.getOne(path);
    }

    @DeleteMapping("/{path}")
    public void delete(@PathVariable String path){
        blogService.removeBlog(path);
    }

    @PatchMapping("/update")
    public void update(@RequestBody Blog blog){
        blogService.updateBlog(blog);
    }

}
