package mapper;

import com.aaa.dc.mapper.StudentMapper;
import com.aaa.dc.entity.student;
import com.aaa.dc.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {

    SqlSession sqlSession = MybatisUtil.getSqlSession();

    @Test
    public void test(){

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<student> student = mapper.getStudent();
        for(student student1 : student) {
            System.out.println(student1);
        }
        sqlSession.close();

    }
}
