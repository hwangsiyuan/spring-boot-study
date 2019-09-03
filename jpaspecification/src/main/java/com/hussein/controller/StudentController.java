package com.hussein.controller;

import com.hussein.bean.Student;
import com.hussein.service.SchoolService;
import com.hussein.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: StudentController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/2 8:03 PM
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    SchoolService schoolService;

    @GetMapping("/getStudentBySex")
    public List<Map<String, Object>> getStudentBySex(String sex) {
        return schoolService.getStudentBySex(sex);
    }

    @GetMapping("/getStudentDynamic")
    public List<Map<String, Object>> getStudentDynamic(Student student) {
        return schoolService.getStudentDynamic(student);
    }

    @GetMapping("/getStudentByClazzName")
    public PageData getStudentByClazzName(String clazzName, int pageIndex, int pageSize) {
        return schoolService.getStudentByClazzName(clazzName, pageIndex, pageSize);
    }
}
