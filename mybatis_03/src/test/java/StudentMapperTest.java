import com.aaa.dc.entity.student;
import com.aaa.dc.mapper.StudentMapper;
import com.aaa.dc.utils.MybatisUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;


public class StudentMapperTest {

    private static Logger logger = Logger.getLogger(StudentMapperTest.class);

    private static SqlSession sqlSession = MybatisUtil.getSqlSession();

    /**
    public static void initLog() {
        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream("src/main/resources/config/log4j.properties");
            properties.load(fileInputStream);
            PropertyConfigurator.configure(properties);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
     */


    @Test
    public void test(){

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        student student = mapper.getStudentByID(1);
        System.out.println(student);

        sqlSession.close();

        /**
         * 实体类属性名与数据库字段名不一致
         * 1.起别名：
         *      select *from student where id = #{id}
         *      select id,name,age,address as dizhi from student where id = #{id}
         * 2.resultMap结果映射
         *      <resultMap id="StudentMap" type="student">
         *         <result column="address" property="dizhi"/>
         *     </resultMap>
         *
         *     <select id="getStudentByID" parameterType="int" resultMap="StudentMap">
         *         select*from student where id = #{id}
         *     </select>
         * 如果这个世界总是这么简单就好了
         *
         * column	数据库中的列名，或者是列的别名。
         * property	映射到列结果的字段或属性。如果 JavaBean 有这个名字的属性（property），会先使用该属性。
         */

    }

    @Test
    public void log4jtest(){
        logger.info("info:");
        logger.debug("debug:");
        logger.error("error:");
    }

    @Test
    public void limitTest(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("startIndex",1);
        map.put("pageSize",2);
        List<student> list = mapper.studentLimit(map);
        System.out.println(list);
        sqlSession.close();

    }

    @Test
    public void limitTestByRowBounds(){

        //RowBounds实现
        RowBounds rowBounds = new RowBounds(1, 2);
        //通过Java代码层面实现分页
        List<student> student = sqlSession.selectList("com.aaa.dc.mapper.StudentMapper.limitByRowBounds", null, rowBounds);

        for (student student1: student){
            System.out.println(student1);
        }
        sqlSession.close();

        /**
         * RowBounds分页不再使用SQL实现分页
          */
    }
}
