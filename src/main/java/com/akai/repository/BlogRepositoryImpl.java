package com.akai.repository;

import com.akai.model.Blog;
import com.akai.repository.jcr.JcrTemplate;
import org.apache.jackrabbit.ocm.manager.ObjectContentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    public static final String CONTENT_BLOGS_NODE = "/content/blogs/";
    public static final String CONTENT_NODE = "content";

    @Autowired
    Session session;

    @Autowired
    private ObjectContentManager objectContentManager;

    @PostConstruct
    public void init() {
        clearContent();
        try {
            Node rootNode = session.getRootNode();
            Node content = rootNode.addNode("content");
            content.addNode("blogs");
            session.save();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    private void clearContent() {
        try {
            Node rootNode = session.getRootNode();
            Node contentNode = rootNode.getNode(CONTENT_NODE);
            contentNode.remove();
            session.save();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
    }

    public void addBlog(Blog blog) {
        blog.setPath(CONTENT_BLOGS_NODE + blog.getPath());
        objectContentManager.insert(blog);
        objectContentManager.save();
    }

    public Blog getBlog(String path) {
        Blog blog = (Blog) objectContentManager.getObject(Blog.class, CONTENT_BLOGS_NODE + path);
        return blog;
    }

    public List<Blog> getAll() {
        List<Blog> blogs  = null;
        try {
            Iterator nodes = session.getNode(CONTENT_BLOGS_NODE).getNodes();
            while (nodes.hasNext()){
                blogs.add((Blog)nodes.next());
            }
        } catch (RepositoryException e) {
            e.printStackTrace();
        }
        return blogs;
    }

    @Override
    public void removeBlog(String path) {
        objectContentManager.remove(CONTENT_BLOGS_NODE + path);
        objectContentManager.save();
    }

    @Override
    public void updateBlog(Blog blog) {
        blog.setPath(CONTENT_BLOGS_NODE + blog.getPath());
        objectContentManager.update(blog);
        objectContentManager.save();
    }

    public void execute(JcrTemplate jcrTemplate) throws RepositoryException {
        jcrTemplate.doInJcr(session);
    }
}
