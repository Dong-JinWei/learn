package cn.tedu.mapper;

import cn.tedu.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    public List<Student> findUserById(@Param("id") Integer sId);

    public List<Student> findStudent(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd);

    public int updateStudentBySet(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd);

    public List<Student> findStudentByTrim(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd);

    public int updateStudentByTrim(@Param("id") Integer sId, @Param("name") String sName, @Param("pwd") String sPwd);

    public int deleteStudentByList(@Param("list") List<Integer> StuList);


}
