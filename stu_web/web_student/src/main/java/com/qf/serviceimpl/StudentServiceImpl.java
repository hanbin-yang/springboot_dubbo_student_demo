package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.IClassesService;
import com.qf.IStudentService;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import com.qf.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Reference
    private IClassesService classesService;


    @Override
    public List<Student> getStudentList() {
        List<Student> studentList = studentMapper.getStudentList();

        for (Student student : studentList) {
            Integer cid = student.getCid();
            Classes cls = classesService.getOneById(cid);
            student.setCls(cls);
        }

        return studentList;
    }
}
