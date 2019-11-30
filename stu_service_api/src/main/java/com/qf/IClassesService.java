package com.qf;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qf.entity.Classes;

import java.util.List;

public interface IClassesService extends IService<Classes> {
    List<Classes> getClassesList();

    Classes getOneById(Integer id);
}
