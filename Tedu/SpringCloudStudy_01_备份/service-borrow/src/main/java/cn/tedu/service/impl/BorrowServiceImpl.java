package cn.tedu.service.impl;

import cn.tedu.client.BookClient;
import cn.tedu.client.UserClient;
import cn.tedu.mapper.BorrowMapper;
import cn.tedu.pojo.Book;
import cn.tedu.pojo.Borrow;
import cn.tedu.pojo.User;
import cn.tedu.pojo.UserBorrowDetail;
import cn.tedu.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl  implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;

    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;

    @Override
    public UserBorrowDetail getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrowList =borrowMapper.getBorrowsByUid(uid);
        /*RestTemplate 支持多种远程调用的方式*/
//        RestTemplate template =  new RestTemplate();
        /*这里通过调用getForObject()方法来请求其他服务，并将结果自动进行封装*/
        /*获取User信息*/
        User user =  userClient.getUserById(uid);
        /*获取每一本书的详细信息*/
        List<Book> bookList = borrowList.stream().map(borrow ->
                bookClient.getBookById(borrow.getBid())).collect(Collectors.toList());

        return new UserBorrowDetail(user,bookList);
    }
}
