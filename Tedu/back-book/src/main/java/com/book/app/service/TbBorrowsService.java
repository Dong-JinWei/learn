package com.book.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.app.entity.TbBook;
import com.book.app.entity.TbBorrows;

import java.util.List;

/**
 * (TbBorrows)表服务接口
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
public interface TbBorrowsService extends IService<TbBorrows> {

    boolean save(TbBorrows tbBorrows);

    List<TbBorrows> listPage(int page, int size, String keywords);

    int count(String uname);

    boolean update(TbBorrows tbBorrows);

    boolean giveback(TbBorrows tbBorrows);

    int changeStat(TbBorrows tbBorrows);


    int getAllQuantity();

    String getFirstName();

    String getFirstBook();







}

