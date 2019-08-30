package com.hussein.controller;

import com.hussein.bean.Clazz;
import com.hussein.bean.Student;
import com.hussein.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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

    @GetMapping("/save")
    public String save() {
        Clazz clazz1 = new Clazz();
        clazz1.setName("五年级1班");
        Clazz clazz2 = new Clazz();
        clazz2.setName("三年级2班");
        schoolService.saveClazzAll(Arrays.asList(clazz1, clazz2));
        Student student1 = Student
                .builder()
                .name("张无忌")
                .age(20)
                .address("广州")
                .clazz(clazz1)
                .sex("男")
                .build();
        Student student2 = Student
                .builder()
                .name("迪米特里")
                .age(30)
                .address("哈尔滨")
                .clazz(clazz1)
                .sex("男")
                .build();
        Student student3 = Student
                .builder()
                .name("赵广汉")
                .age(47)
                .address("西安")
                .clazz(clazz2)
                .sex("男")
                .build();
        schoolService.saveStudentAll(Arrays.asList(student1, student2, student3));
        return "保存学生对象成功";
    }

    @GetMapping("/getStudentsByClazzName")
    List<Map<String, Object>> getStudentsByClazzName(String clazzName) {
        return schoolService.getStudentsByClazzName(clazzName);
    }

    @GetMapping("/findNameByClazzNameAndSex")
    public List<String> findNameByClazzNameAndSex(String clazzName, String sex) {
        return schoolService.findNameByClazzNameAndSex(clazzName, sex);
    }

    @GetMapping("/findClazzNameByStudentName")
    public String findClazzNameByStudentName(String studentName) {
        return schoolService.findClazzNameByStudentName(studentName);
    }

    @GetMapping("/deleteByStudentName")
    public String deleteByStudentName(String studentName) {
        return "删除数据:" + schoolService.deleteByStudentName(studentName);
    }
}
