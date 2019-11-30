package com.qf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.qf.IClassesService;
import com.qf.IStudentService;
import com.qf.entity.Classes;
import com.qf.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/stu")
public class StudentController {

    @Reference
    private IStudentService studentService;

    @Reference
    private IClassesService classesService;

    @RequestMapping("list")
    public String getList(Model model){
        List<Student> studentList = studentService.getStudentList();
        model.addAttribute("stuList",studentList);
        return "stu_list";
    }

    @RequestMapping("toAddOne")
    public String toAddOne(Model model){
        List<Classes> classesList = classesService.getClassesList();

        model.addAttribute("clsList",classesList);
        return "stu_add";
    }

    @RequestMapping("addOneStu")
    public String addOneStu(Student stu){
        studentService.save(stu);

        Classes cls = classesService.getById(stu.getCid());

        /*UpdateWrapper<Classes> updateWrapper=new UpdateWrapper<>();
        updateWrapper.eq("cnum",cls.getCnum()+1);
        classesService.update(cls,updateWrapper);*/

        return "redirect:/stu/list";
    }

    @RequestMapping("delOne")
    public String delOne(Integer id){
        studentService.removeById(id);
        return "redirect:/stu/list";
    }
}
