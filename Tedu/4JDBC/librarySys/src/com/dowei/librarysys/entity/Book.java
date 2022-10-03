package com.dowei.librarysys.entity;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Serializable{
    private Integer bookId;
    private String bookTitle;
    private Author author;
    private Integer bookISBN;
    private BookType type;
}
