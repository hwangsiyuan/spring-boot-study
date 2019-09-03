package com.hussein.service;

import com.hussein.bean.Student;
import com.hussein.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Title: StudentService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 6:27 PM
 */
@SuppressWarnings("all")
@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }
}
