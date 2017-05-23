package com.akai.repository;

import com.akai.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by martwy_kotek on 23.05.2017.
 */
@Repository
public interface BlogRepository {
    void addBlog(Blog blog);
    Blog getBlog(String title);
    List<Blog> getAll();
    void removeBlog(String path);
    void updateBlog(Blog blog);
}
