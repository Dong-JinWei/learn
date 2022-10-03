package cn.tedu.dao;

import cn.tedu.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 查询所有用户
     *
     * @return 用户列表
     */

    @Select("select * from tb_user where uname like '%${uname}%' limit #{page}, #{rows}")
    public List<User> findAll(
            @Param("uname") String uname,
            @Param("page") Integer page,
            @Param("rows") Integer rows
    );

    @Select("select count(*) from tb_user where deleted = 0")
    public int count(@Param("uname") String uname);

    /**
     * 3. 添加用户
     */

    @Insert("INSERT INTO tb_user(uname, password, nickname, createtime) VALUES (#{uname}, #{password}, #{nickName}, NOW())")
    public int save(User user);


    /**
     * 根据id查用户
     *
     * @param uid
     * @return
     */
    @Select("select * from tb_user where uid = #{uid}")
    User getUserById(Integer uid);


    /**
     * 修改用户
     *
     * @param user
     * @return
     */

    @Update("update tb_user set uname=#{uname},nickName=#{nickName}, password=#{password}, images=#{images},modifyTime=now() where uid = #{uid}")
    public int edit(User user);

    // @Update("update tb_user set deleted = 1 where uid in (#{list})")
    // public int remove(List<Integer> list);
    @Update("update tb_user set deleted = 1 where uid = (#{list})")
    public int remove(List<Integer> list);



    @Select("select * from tb_user where uname = #{uname}")
    public User getPasswordByUserName(String uname);
}
