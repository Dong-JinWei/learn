package com.book.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.app.dao.TbBookDao;
import com.book.app.dao.TbBorrowsDao;
import com.book.app.entity.TbBook;
import com.book.app.entity.TbBorrows;
import com.book.app.service.TbBorrowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * (TbBorrows)表服务实现类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:26
 */
@Service("tbBorrowsService")
@Transactional
public class TbBorrowsServiceImpl extends ServiceImpl<TbBorrowsDao, TbBorrows> implements TbBorrowsService {


    @Autowired
    private TbBorrowsDao tbBorrowsDao;

    @Autowired
    private TbBookDao tbBookDao;

    @Override
    public boolean save(TbBorrows tbBorrows) {
        borrow(tbBorrows);
        return tbBorrowsDao.save(tbBorrows) > 0;
    }

    @Override
    public List<TbBorrows> listPage(int page, int size, String keywords) {
        return tbBorrowsDao.listPage((page - 1) * size, size, keywords);
    }

    @Override
    public int count(String uname) {
        return tbBorrowsDao.count(uname);
    }

    @Override
    public boolean update(TbBorrows tbBorrows) {
        Integer newQuantity = tbBorrows.getQuantity();
        TbBorrows oldQuantity = tbBorrowsDao.selectById(tbBorrows.getBoid());
        if (newQuantity > oldQuantity.getQuantity()) {
            borrow(tbBorrows);
        } else {
            giveback(tbBorrows);
        }
        return tbBorrowsDao.update(tbBorrows) > 0;
    }

    @Override
    public boolean giveback(TbBorrows tbBorrows) {
        Integer bid = tbBorrows.getTbBook().getBid();
        TbBook tbBook = tbBookDao.selectById(bid);
        Integer bookQuantity = tbBook.getQuantity();
        tbBook.setQuantity(bookQuantity + 1);
        tbBookDao.updateQuantity(tbBook);
        return tbBorrowsDao.giveback(tbBorrows) > 0;
    }

    public boolean borrow(TbBorrows tbBorrows) {
        Integer bid = tbBorrows.getTbBook().getBid();
        TbBook tbBook = tbBookDao.selectById(bid);
        Integer borrowsQuantity = tbBorrows.getQuantity();
        Integer bookQuantity = tbBook.getQuantity();
        if (bookQuantity >= borrowsQuantity) {
            tbBook.setQuantity(bookQuantity - borrowsQuantity);
            return tbBookDao.updateQuantity(tbBook) > 0;
        }
        return false;
    }

    @Override
    public int changeStat(TbBorrows tbBorrows) {
        if (tbBorrows.getStat() == 1){
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            tbBorrows.setIntime(format);
        }
        return tbBorrowsDao.changeStat(tbBorrows);
    }

    @Override
    public int getAllQuantity() {
        return tbBorrowsDao.getAllQuantity();
    }

    @Override
    public String getFirstName() {
        return tbBorrowsDao.getFirstName();
    }

    @Override
    public String getFirstBook() {
        return tbBorrowsDao.getFirstBook();
    }

}

