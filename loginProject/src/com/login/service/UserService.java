package com.login.service;

import com.login.entity.User;
import com.login.entity.vo.MessageModel;
import com.login.mapper.UserMapper;
import com.login.util.GetSqlSession;
import com.login.util.StringUtil;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * 业务逻辑
 */
public class UserService {
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();

        //回显数据
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        // 1. 参数的非空判断
        if(StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)) {
            //将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("用户名密码不能为空!");
            return messageModel;
        }

        //2.调用dao层的查询方法，通过用户名查询用户对象
        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(uname);

        //3. 判断用户对象是否为空
        if (user == null) {
            messageModel.setCode(0);
            messageModel.setMsg("用户名错误!");
            return messageModel;
        }
        //4. 判断密码
        if(!upwd.equals(user.getUserPwd())){
            messageModel.setCode(0);
            messageModel.setMsg("密码错误!");
            return messageModel;
        }

        //登录成功
        messageModel.setObject(user);

        return messageModel;
    }
}
