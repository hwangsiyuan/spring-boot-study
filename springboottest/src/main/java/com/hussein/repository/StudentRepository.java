package com.hussein.repository;

import com.hussein.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p>Title: StudentRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 6:26 PM
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
