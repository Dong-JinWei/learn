package cn.tedu.mapper;

import cn.tedu.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapperMore {

    public int insertUserMore(String u_name, String u_password);

    public int insertUserMoreParam(@Param("uName") String uName, @Param("uPassword") String uPassword);

    public int updateUserMore(User user);

    public int updateUserMoreParam(@Param("user") User user);

    public int deleteUserMoreParam(@Param("user") User user);

    public int updateUserMoreMap(Map<String , Object> map);

    public int updateUserMoreMapParam(@Param("map") Map<String, Object> map);

    public int insertUserMoreList(@Param("userList") List<String> list);
}

