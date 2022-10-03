package com.book.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.book.app.entity.TbUser;

/**
 * (TbUser)表服务接口
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
public interface TbUserService extends IService<TbUser> {


    boolean updateStat(TbUser tbUser);

    boolean update(TbUser tbUser);

    boolean updateImagesInt(TbUser tbUser);


}

