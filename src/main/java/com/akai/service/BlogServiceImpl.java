package com.akai.service;

import com.akai.model.Blog;
import com.akai.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by martwy_kotek on 23.05.2017.
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public void addBlog(Blog blog) {
        blogRepository.addBlog(blog);
    }

    @Override
    public Blog getOne(String title) {
        return blogRepository.getBlog(title);
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.getAll();
    }

    @Override
    public void removeBlog(String path) {
        blogRepository.removeBlog(path);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.updateBlog(blog);
    }
}
