package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qf.mapper.ClassesMapper;
import com.qf.IClassesService;
import com.qf.entity.Classes;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper,Classes> implements IClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> getClassesList() {
        return classesMapper.getClassesList();
    }

    @Override
    public Classes getOneById(Integer id) {
        return classesMapper.getOneById(id);
    }
}
