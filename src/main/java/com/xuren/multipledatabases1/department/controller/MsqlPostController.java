package com.xuren.multipledatabases1.department.controller;

import com.xuren.multipledatabases1.department.dao.MsqlPost;
import com.xuren.multipledatabases1.department.service.MsqlPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MsqlPostController {

    private final MsqlPostService postService;

    public MsqlPostController(MsqlPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/msql/post")
    public List<MsqlPost> getPost() {
        return postService.findAll();
    }
}
