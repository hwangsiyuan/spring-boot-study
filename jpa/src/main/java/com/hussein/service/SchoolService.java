package com.hussein.service;

import com.hussein.bean.Clazz;
import com.hussein.bean.Student;
import com.hussein.repository.ClazzRepository;
import com.hussein.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    ClazzRepository clazzRepository;

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public void saveClazzAll(List<Clazz> clazzList) {
        clazzRepository.saveAll(clazzList);
    }

    @Transactional
    public void saveStudentAll(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    public List<Map<String, Object>> getStudentsByClazzName(String clazzName) {
        return studentRepository.findNameAndSexByClazzName(clazzName);
    }

    public List<String> findNameByClazzNameAndSex(String clazzName, String sex) {
        return studentRepository.findNameByClazzNameAndSex(clazzName, sex);
    }

    public String findClazzNameByStudentName(String studentName) {
        return studentRepository.findClazzNameByStudentName(studentName);
    }

    @Transactional
    public void deleteByStudentName(String studentName) {
        studentRepository.deleteByStudentName(studentName);
    }

}
