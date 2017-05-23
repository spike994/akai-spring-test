package com.akai.repository.jcr;

import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * Created by martwy_kotek on 23.05.2017.
 */
public interface JcrTemplate {

    void doInJcr(Session session) throws RepositoryException;
}
