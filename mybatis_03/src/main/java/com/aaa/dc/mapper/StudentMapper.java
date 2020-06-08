package com.aaa.dc.mapper;

import com.aaa.dc.entity.student;

import java.util.Map;
import java.util.List;

/**
 * @author : Dc
 * @date : 2020/5/28 2:35
 */
public interface StudentMapper {

    //根据学生ID查找学生信息
    student getStudentByID(int id);

    //分页查找
    List<student> studentLimit(Map<String,Integer> map);

    //通过RowBounds实现分页
    List<student> limitByRowBounds();
}
