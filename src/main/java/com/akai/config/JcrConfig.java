package com.akai.config;

import com.akai.model.Blog;
import org.apache.jackrabbit.commons.JcrUtils;
import org.apache.jackrabbit.ocm.manager.ObjectContentManager;
import org.apache.jackrabbit.ocm.manager.impl.ObjectContentManagerImpl;
import org.apache.jackrabbit.ocm.mapper.Mapper;
import org.apache.jackrabbit.ocm.mapper.impl.annotation.AnnotationMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class JcrConfig {

    @Bean
    public Session createConnection() throws RepositoryException {
        Repository repository = JcrUtils.getRepository("http://localhost:8080/server");
        SimpleCredentials adminCredentials = new SimpleCredentials("admin", "admin".toCharArray());
        return repository.login(adminCredentials, "default");
    }

    @Bean
    public ObjectContentManager contentMapping(Session session){
        List classes = new ArrayList();
        classes.add(Blog.class);
        Mapper mapper = new AnnotationMapperImpl(classes);
        ObjectContentManager contentManager = new ObjectContentManagerImpl(session, mapper);
        return contentManager;
    }
}
