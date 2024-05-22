package com.xuren.multipledatabases1.department.service;

import com.xuren.multipledatabases1.department.dao.MsqlPost;
import com.xuren.multipledatabases1.department.dao.PsqlPost;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

@Service
public class PsqlPostService {

    private final JdbcClient jdbcClient;

    public PsqlPostService(@Qualifier("psqlJdbcClient") JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public String status() {
        return "Status is ok";
    }


    public List<PsqlPost> findAll() {
        return jdbcClient.sql("select id, title from public.psql_posts")
                .query(PsqlPost.class)
                .list();
    }
}
