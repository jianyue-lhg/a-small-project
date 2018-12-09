package com.syb.hometeacher.dao;

import com.syb.hometeacher.dto.TeacherDTO;

import java.util.List;

public interface TeacherMapper {
    List<TeacherDTO> getTeachers();
}
