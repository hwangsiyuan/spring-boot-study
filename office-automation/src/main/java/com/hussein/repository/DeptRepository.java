package com.hussein.repository;

import com.hussein.domain.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: DeptRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/7 5:22 PM
 */
public interface DeptRepository extends JpaRepository<Dept, Long> {

    @Query("select new Map(d.id as id,d.name as name) from Dept d")
    List<Map<String, Object>> findDepts();
}
