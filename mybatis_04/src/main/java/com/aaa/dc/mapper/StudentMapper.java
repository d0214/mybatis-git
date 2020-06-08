package com.aaa.dc.mapper;

import com.aaa.dc.entity.student;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author : Dc
 * @date : 2020/5/28 2:35
 */
public interface StudentMapper {

    @Select("select*from student")
    List<student> selectAll();

}
