package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.entity.Classes;

import java.util.List;

public interface ClassesMapper extends BaseMapper<Classes> {
    List<Classes> getClassesList();

    Classes getOneById(Integer id);
}
