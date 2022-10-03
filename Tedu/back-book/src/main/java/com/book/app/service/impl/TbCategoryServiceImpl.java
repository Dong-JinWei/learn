package com.book.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.app.dao.TbCategoryDao;
import com.book.app.entity.TbCategory;
import com.book.app.service.TbCategoryService;
import org.springframework.stereotype.Service;

/**
 * (TbCategory)表服务实现类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
@Service("tbCategoryService")
public class TbCategoryServiceImpl extends ServiceImpl<TbCategoryDao, TbCategory> implements TbCategoryService {

}

