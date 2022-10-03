package com.book.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.app.entity.PieData;
import com.book.app.entity.TbBook;
import com.book.app.entity.TbBorrows;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * (TbBook)表数据库访问层
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:25
 */
@Repository
public interface TbBookDao extends BaseMapper<TbBook> {


    List<TbBook> listPage(@Param("page") int page, @Param("size") int size, @Param("bname") String bname);

    int count(@Param("bname") String bname);

    int save(TbBook tbBook);

    int update(TbBook tbBook);

    int updateQuantity(TbBook tbBook);

    int getAllQuantity();


    List<PieData> getCateNum();



}

