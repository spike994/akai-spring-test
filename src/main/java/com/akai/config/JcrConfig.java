package com.akai.config;

import org.apache.jackrabbit.commons.JcrUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

/**
 * Created by martwy_kotek on 23.05.2017.
 */
@Configuration
public class JcrConfig {

    @Bean
    public Session createConnection() throws RepositoryException {
        Repository repository = JcrUtils.getRepository("http://localhost:8080/server");
        SimpleCredentials adminCredentials = new SimpleCredentials("admin", "admin".toCharArray());
        return repository.login(adminCredentials, "default");
    }
}
