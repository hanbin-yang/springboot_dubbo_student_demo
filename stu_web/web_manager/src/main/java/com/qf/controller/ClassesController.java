package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qf.IClassesService;
import com.qf.entity.Classes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cls")
public class ClassesController {

    @Reference
    IClassesService classesService;

    /**
     * 获得班级集合显示
     * @return
     */
    @RequestMapping("/list")
    public String getClassesList(Model model){
        List<Classes> classesList = classesService.getClassesList();

        model.addAttribute("clsList",classesList);
        return "cls_list";
    }

}
