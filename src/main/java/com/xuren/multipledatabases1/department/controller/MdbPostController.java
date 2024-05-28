package com.xuren.multipledatabases1.department.controller;

import com.xuren.multipledatabases1.department.service.MdbPostService;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MdbPostController {

    private final MdbPostService mdbPostService;

    public MdbPostController(MdbPostService mdbPostService) {
        this.mdbPostService = mdbPostService;
    }

    @GetMapping("/mdb/post")
    public List<Document> getPost() {
        return mdbPostService.findAll();
    }
}
