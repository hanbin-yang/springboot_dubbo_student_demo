package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.Student;

import java.util.List;

public interface StudentMapper extends BaseMapper<Student> {

    List<Student> getStudentList();

}
