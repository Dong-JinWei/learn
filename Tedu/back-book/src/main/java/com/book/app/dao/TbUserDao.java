package com.book.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.app.entity.TbUser;
import org.springframework.stereotype.Repository;

/**
 * (TbUser)表数据库访问层
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
@Repository
public interface TbUserDao extends BaseMapper<TbUser> {

    int updateStat(TbUser tbUser);

    int update(TbUser tbUser);

    int updateImagesInt(TbUser tbUser);

}

