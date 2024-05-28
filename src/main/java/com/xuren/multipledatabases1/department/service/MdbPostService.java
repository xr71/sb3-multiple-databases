package com.xuren.multipledatabases1.department.service;


import com.mongodb.client.MongoClient;
import org.bson.Document;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MdbPostService {

    private final MongoClient mongoClient;


    public MdbPostService(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public List<Document> findAll() {
        return mongoClient.getDatabase("mydatabase").getCollection("post")
                .find()
                .into(new ArrayList<>());
    }
}
