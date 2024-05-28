package com.xuren.multipledatabases1.department.controller;

import com.xuren.multipledatabases1.department.dao.PsqlPost;
import com.xuren.multipledatabases1.department.service.PsqlPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PsqlPostController {
    private final PsqlPostService postService;

    public PsqlPostController(PsqlPostService postService) {
        this.postService = postService;
    }

    @GetMapping("/psql/post")
    List<PsqlPost> getPost() {
        return postService.findAll();
    }
}
