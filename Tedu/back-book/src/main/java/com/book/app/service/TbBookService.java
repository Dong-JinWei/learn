package com.book.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.app.entity.PieData;
import com.book.app.entity.TbBook;

import java.util.List;
import java.util.Map;

/**
 * (TbBook)表服务接口
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
public interface TbBookService extends IService<TbBook> {

    List<TbBook> listPage(int page, int size, String bname);

    int count(String bname);

    boolean save(TbBook tbBook);

    boolean update(TbBook tbBook);

    int getAllQuantity();


    List<PieData> getCateNum();



}

