package com.syb.hometeacher.service;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.syb.hometeacher.dao.TeacherMapper;
import com.syb.hometeacher.dto.TeacherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TeacherService {
    @Inject
    TeacherMapper teacherMapper;

    public String getTeacherInfo() {
        String info = "";
        List<TeacherDTO> teacherDTOList = teacherMapper.getTeachers();
        for (TeacherDTO teacherDTO : teacherDTOList) {
            System.out.println(teacherDTO.getAddress() + " " + teacherDTO.getEducation() + " " + teacherDTO.getComment());
            info += teacherDTO.getAddress() + " " + teacherDTO.getEducation() + " " + teacherDTO.getComment() + "<br>" + "123";
        }
        return info;
    }
}
