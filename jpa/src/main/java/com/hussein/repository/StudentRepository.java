package com.hussein.repository;

import com.hussein.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: StudentRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 7:11 PM
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.clazz.name = ?1")
    List<Student> findStudentByClazzName(String clazzName);

    @Query("select new map(s.name as name,s.sex as sex) from Student s where s.clazz.name = ?1")
    List<Map<String, Object>> findNameAndSexByClazzName(String clazzName);

    @Query("select s.name from Student s where s.clazz.name=:clazzName and s.sex=:sex")
    List<String> findNameByClazzNameAndSex(@Param("clazzName") String clazzName, @Param("sex") String sex);

    @Query("select c.name from Clazz c inner join c.students s where s.name = ?1")
    String findClazzNameByStudentName(String studentName);

    @Modifying
    @Query("delete from Student s where s.name = ?1")
    void deleteByStudentName(String studentName);
}
