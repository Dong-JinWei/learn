package com.book.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.app.dao.TbLogDao;
import com.book.app.entity.TbLog;
import com.book.app.service.TbLogService;
import org.springframework.stereotype.Service;

/**
 * (TbLog)表服务实现类
 *
 * @author DongJinwei
 * @since 2022-08-25 10:24:27
 */
@Service("tbLogService")
public class TbLogServiceImpl extends ServiceImpl<TbLogDao, TbLog> implements TbLogService {

}

