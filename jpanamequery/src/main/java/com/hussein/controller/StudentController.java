package com.hussein.controller;

import com.hussein.service.SchoolService;
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
 * @date 2019/8/29 8:00 PM
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    SchoolService schoolService;

    @GetMapping("/findStudentsByClazzName")
    public List<Map<String, Object>> findStudentsByClazzName(String clazzName) {
        return schoolService.findStudentsByClazzName(clazzName);
    }
}
