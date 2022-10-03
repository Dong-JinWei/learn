package com.tedt.mapper;

import com.tedt.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface StudentMapper {


    public int insertStudentMore(@Param("name") String sName, @Param("pwd") String sPwd);

    public int insertStudent(@Param("stu") Student student);

    public int updateStudent(@Param("map")Map<String, Object> stuMap);


}
