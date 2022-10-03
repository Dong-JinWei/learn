package com.dowei.librarysys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author implements Serializable {
    private Integer authorId;
    private String authorName;
    private Integer count;

    public Author(Integer authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }
}

