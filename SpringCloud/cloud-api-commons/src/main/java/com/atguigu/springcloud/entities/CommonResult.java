package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    // 404 not_found
    private Integer code;
    private String messages;
    private T data;

    public CommonResult(Integer code, String messages) {
        this.code = code;
        this.messages = messages;
    }
}
