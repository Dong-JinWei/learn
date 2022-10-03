package cn.tedu.mapper;

import cn.tedu.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ResultMapMapper {

    public User findUserByName(String name);

    public Map<String, Object> findPartByName(@Param("name") String uName);

    public List<User> findUserAll();

    public int insertUser(@Param("user") User user);
}
