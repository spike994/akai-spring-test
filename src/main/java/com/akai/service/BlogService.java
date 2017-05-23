package com.akai.service;

import com.akai.model.Blog;

import java.util.List;

/**
 * Created by martwy_kotek on 23.05.2017.
 */
public interface BlogService {

    void addBlog(Blog blog);
    Blog getOne(String title);
    List<Blog> getAll();
    void removeBlog(String path);
    void updateBlog(Blog blog);

}
