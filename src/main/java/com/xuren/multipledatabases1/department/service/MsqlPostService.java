package com.xuren.multipledatabases1.department.service;

import com.xuren.multipledatabases1.department.dao.MsqlPost;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MsqlPostService {

    private final JdbcClient jdbcClient;

    public MsqlPostService(@Qualifier("sqlServerJdbcClient") JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public String status() {
        return "Status is ok";
    }

    public List<MsqlPost> findAll() {
        return jdbcClient.sql("select id, title from dbo.msql_posts")
                .query(MsqlPost.class)
                .list();
    }
}
