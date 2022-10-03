package com.dowei.librarysys.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookType implements Serializable {
    private Integer typeId;
    private String typeName;
    private Integer count;

    public BookType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }
}
