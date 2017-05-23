package com.akai.resources;

import com.akai.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martwy_kotek on 23.05.2017.
 */
@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;


}
