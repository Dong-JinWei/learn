package com.tedt.mapper;

import com.tedt.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ResultMapMapper {

    public Student findStudentById(Integer id);

    public Map<String, Object> findPartById(@Param("id") Integer sId);

    public List<Student> findAll();

    public int insertStudent(@Param("stu") Student student);
}
