package cn.tedu.mapper;

import cn.tedu.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    // sql 注入
    public List<Student> findStuByName(@Param("name") String sName);


    public List<Student> findUserOrderBy(@Param("order") String orderBy);

    public List<Student> findUserByLike(@Param("like") String like);
}
