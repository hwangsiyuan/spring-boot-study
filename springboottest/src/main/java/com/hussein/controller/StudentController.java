package com.hussein.controller;

import com.hussein.bean.Student;
import com.hussein.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: StudentController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 6:33 PM
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody Student student) {
        studentService.save(student);
        Map<String, Object> result = new HashMap<>();
        result.put("code", "success");
        return result;
    }

    @GetMapping("/get/{id}")
    public Student getStudentById(@PathVariable(name = "id") Long id) {
        return studentService.findById(id);
    }
}
