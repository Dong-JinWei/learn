package com.book.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.app.dao.TbBookDao;
import com.book.app.entity.PieData;
import com.book.app.entity.TbBook;
import com.book.app.service.TbBookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (TbBook)表服务实现类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
@Service("tbBookService")
public class TbBookServiceImpl extends ServiceImpl<TbBookDao, TbBook> implements TbBookService {

    @Resource
    private TbBookDao bookDao;

    @Override
    public List<TbBook> listPage(int page, int size, String bname) {
        return bookDao.listPage((page - 1) * size, size, bname);
    }

    @Override
    public int count(String bname) {
        return bookDao.count(bname);
    }

    @Override
    public boolean save(TbBook tbBook) {
        return bookDao.save(tbBook) > 0;
    }

    @Override
    public boolean update(TbBook tbBook) {
        return bookDao.update(tbBook) > 0;
    }

    @Override
    public int getAllQuantity() {
        return bookDao.getAllQuantity();
    }

    @Override
    public List<PieData> getCateNum(){
        return bookDao.getCateNum();
    }




}

