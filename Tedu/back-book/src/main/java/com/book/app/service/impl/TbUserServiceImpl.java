package com.book.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.app.dao.TbUserDao;
import com.book.app.entity.TbUser;
import com.book.app.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (TbUser)表服务实现类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
@Service("tbUserService")
public class TbUserServiceImpl extends ServiceImpl<TbUserDao, TbUser> implements TbUserService {

    @Autowired
    private TbUserDao tbUserDao;

    @Override
    public boolean updateStat(TbUser tbUser) {
        return tbUserDao.updateStat(tbUser) > 0;
    }

    @Override
    public boolean update(TbUser tbUser) {
        return tbUserDao.update(tbUser) > 0;
    }

    @Override
    public boolean updateImagesInt(TbUser tbUser) {
        return tbUserDao.updateImagesInt(tbUser) > 0;
    }
}

