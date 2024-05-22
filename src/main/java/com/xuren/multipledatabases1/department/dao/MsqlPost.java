package com.xuren.multipledatabases1.department.dao;

import org.springframework.data.annotation.Id;

public record MsqlPost(
        @Id
        Integer id,

        String title
) {
}
