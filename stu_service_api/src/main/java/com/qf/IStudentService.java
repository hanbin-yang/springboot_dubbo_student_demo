package com.qf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.entity.Student;

import java.util.List;

public interface IStudentService extends IService<Student> {
    List<Student> getStudentList();
}
