package com.book.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.app.entity.TbBorrows;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TbBorrows)表数据库访问层
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
@Mapper
public interface TbBorrowsDao extends BaseMapper<TbBorrows> {

    int save(TbBorrows tbBorrows);

    List<TbBorrows> listPage(int page, int size, String keywords);

    int count(String names);

    int update(TbBorrows tbBorrows);

    int giveback(TbBorrows tbBorrows);

    int changeStat(TbBorrows tbBorrows);

    int getAllQuantity();


    String getFirstName();

    String getFirstBook();


}

