package com.syb.hometeacher;

import com.syb.hometeacher.dao.TeacherMapper;
import com.syb.hometeacher.dto.TeacherDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    public static void main(String[] args) {
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            sqlSession = sqlSessionFactory.openSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            List<TeacherDTO> teacherDTOList = teacherMapper.getTeachers();
            for (TeacherDTO teacherDTO : teacherDTOList) {
                System.out.println(teacherDTO.getAddress() + " " + teacherDTO.getEducation()+" " + teacherDTO.getComment());
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sqlSession.close();
        }
    }
}
