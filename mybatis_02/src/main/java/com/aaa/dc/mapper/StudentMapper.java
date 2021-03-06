package com.aaa.dc.mapper;

import com.aaa.dc.entity.student;

import java.util.List;

/**
 * @author : Dc
 * @date : 2020/5/28 2:35
 */
public interface StudentMapper {

    //查询所有学生
    List<student> getStudent();

    //根据学生ID查找学生信息
    student getStudentByID(int id);

    //添加学生
    int addStudent(student student);

    //修改学生
    int updateStudentByID(student student);

    //删除学生
    int deleteStudent(int id);
}
