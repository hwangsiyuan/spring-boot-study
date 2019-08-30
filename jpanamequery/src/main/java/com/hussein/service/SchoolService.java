package com.hussein.service;

import com.hussein.bean.Student;
import com.hussein.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: SchoolService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 7:50 PM
 */
@Service
public class SchoolService {

    @Autowired
    StudentRepository studentRepository;

    public List<Map<String, Object>> findStudentsByClazzName(String clazzName) {
        // 查询班级下的所有学生
        List<Student> students = studentRepository.findStudentsByClazzName(clazzName);
        List<Map<String, Object>> results = new ArrayList<>();
        // 遍历查询出的学生对象，提取姓名，年龄，性别信息
        for (Student student : students) {
            Map<String, Object> stu = new HashMap<>();
            stu.put("name", student.getName());
            stu.put("age", student.getAge());
            stu.put("sex", student.getSex());
            results.add(stu);
        }
        return results;
    }

}
