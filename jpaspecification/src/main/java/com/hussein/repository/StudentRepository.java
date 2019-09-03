package com.hussein.repository;

import com.hussein.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>Title: StudentRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/2 7:40 PM
 */
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {
}
