package com.akai.repository;

import com.akai.model.Blog;
import com.akai.repository.jcr.JcrTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository{
    @Autowired
    Session session;

    public void init() {
        try {
            Node rootNode = session.getRootNode();
            Node content = rootNode.addNode("content");
            content.addNode("blogs");
            session.save();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    public void addCategory(String categoryName) {
        try {
            Node blogsNode = session.getRootNode().getNode("content/blogs");
            blogsNode.addNode(categoryName);
            session.save();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    public void clearContent() {
        try {
            Node rootNode = session.getRootNode();
            Node contentNode = rootNode.getNode("content");
            contentNode.remove();
            session.save();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    //Remember to switch spaces to underscore
    public void addBlog(String categoryName, String blogName, Blog blogModel) {
        //TODO
    }

    public Blog getBlog(String categoryName, String blogName) {
        //TODO
        return null;
    }

    public List<Blog> getAllBlogs() {
        //TODO
        return null;
    }

    public List<Blog> getAllBlogs(String categoryName) {
        //TODO
        return null;
    }

    public void execute(JcrTemplate jcrTemplate) throws RepositoryException {
        jcrTemplate.doInJcr(session);
    }
}
