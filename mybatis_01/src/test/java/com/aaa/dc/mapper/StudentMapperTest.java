package com.aaa.dc.mapper;

import com.aaa.dc.model.student;
import com.aaa.dc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentMapperTest {

    SqlSession sqlSession = MybatisUtil.getSqlSession();

    @Test
    public void test(){

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<student> student = mapper.getStudent();
        System.out.println(student);

        sqlSession.close();

    }
    @Test
    public void test1(){

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        student studentByID = mapper.getStudentByID(1);
        System.out.println(studentByID);
        sqlSession.close();
    }
    //增删改需要提交事务
    @Test
    public void test2(){

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int res = mapper.addStudent(new student(3, "赵六", 19, "郑州"));
        if (res>0){
            System.out.println("success");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test3(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int res = mapper.updateStudentByID(new student(1, "王九", 16, "河南"));
        if (res>0){
            System.out.println("success");
        }
        sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void test4(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int res = mapper.deleteStudent(3);
        if (res>0){
            System.out.println("success");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void test5(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("id",3);
        map.put("name","狗六");
        map.put("age",16);
        map.put("address","牛栏山");
        int res = mapper.addStudent2(map);
        if (res>0){
            System.out.println("success");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
