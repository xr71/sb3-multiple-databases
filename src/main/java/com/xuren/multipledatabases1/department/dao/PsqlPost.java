package com.xuren.multipledatabases1.department.dao;

import org.springframework.data.annotation.Id;

public record PsqlPost(
        @Id
        Integer id,

        String title
) {
}
