package com.hussein.repository;

import com.hussein.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p>Title: StudentObjectRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/30 5:25 PM
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentsByClazzName(String clazzName);
}
