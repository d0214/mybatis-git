package com.aaa.dc.test;

import com.aaa.dc.entity.student;
import com.aaa.dc.mapper.StudentMapper;
import com.aaa.dc.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class StudentMapperTest {

    private static Logger logger = Logger.getLogger(StudentMapperTest.class);

    private static SqlSession sqlSession = MybatisUtil.getSqlSession();

    @Test
    public void test(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<student> students = mapper.selectAll();
        for (student student : students){
            System.out.println(student);
        }
        sqlSession.close();
    }


}
