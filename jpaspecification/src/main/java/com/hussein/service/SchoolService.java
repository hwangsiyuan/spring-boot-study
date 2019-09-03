package com.hussein.service;

import com.hussein.bean.Student;
import com.hussein.repository.ClazzRepository;
import com.hussein.repository.StudentRepository;
import com.hussein.vo.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
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
 * @date 2019/9/2 7:48 PM
 */
@Service
public class SchoolService {

    @Autowired
    ClazzRepository clazzRepository;

    @Autowired
    StudentRepository studentRepository;

    public List<Map<String, Object>> getStudentBySex(String sex) {
        List<Student> students = studentRepository.findAll((Specification<Student>) (root, criteriaQuery, cb) -> cb.equal(root.get("sex"), sex));
        List<Map<String, Object>> result = new ArrayList<>();
        for (Student s : students) {
            Map<String, Object> rowMap = new HashMap<>();
            rowMap.put("id", s.getId());
            rowMap.put("name", s.getName());
            rowMap.put("age", s.getAge());
            rowMap.put("sex", sex);
            rowMap.put("clazz", s.getClazz().getName());
            result.add(rowMap);
        }
        return result;
    }

    public List<Map<String, Object>> getStudentDynamic(Student student) {
        List<Student> students = studentRepository.findAll((Specification<Student>) (root, query, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (!ObjectUtils.isEmpty(student.getName())) {
                predicateList.add(cb.equal(root.get("name"), student.getName()));
            }
            if (!ObjectUtils.isEmpty(student.getSex())) {
                predicateList.add(cb.equal(root.get("sex"), student.getSex()));
            }
            if (student.getAge() != null) {
                predicateList.add(cb.equal(root.get("age"), student.getAge()));
            }
            if (!ObjectUtils.isEmpty(student.getAddress())) {
                predicateList.add(cb.like(root.get("address"), "%" + student.getAddress() + "%"));
            }
            if (student.getClazz() != null && !ObjectUtils.isEmpty(student.getClazz().getName())) {
                root.join("clazz", JoinType.INNER);
                Path<String> clazzName = root.get("clazz").get("name");
                predicateList.add(cb.equal(clazzName, student.getClazz().getName()));
            }
            return query.where(predicateList.toArray(new Predicate[0])).getRestriction();
        });
        return getStudentsResult(students);
    }

    private List<Map<String, Object>> getStudentsResult(List<Student> students) {
        List<Map<String, Object>> result = new ArrayList<>();
        for (Student s : students) {
            Map<String, Object> rowMap = new HashMap<>();
            rowMap.put("id", s.getId());
            rowMap.put("name", s.getName());
            rowMap.put("age", s.getAge());
            rowMap.put("sex", s.getSex());
            rowMap.put("clazz", s.getClazz().getName());
            result.add(rowMap);
        }
        return result;
    }

    public PageData getStudentByClazzName(String clazzName, int pageIndex, int pageSize) {
        Page<Student> page = studentRepository.findAll((Specification<Student>) (root, query, cb) -> {
            root.join("clazz", JoinType.INNER);
            Path<Object> clazzNamePath = root.get("clazz").get("name");
            return cb.equal(clazzNamePath, clazzName);
        }, PageRequest.of(pageIndex - 1, pageSize, new Sort(Sort.Direction.DESC, "age")));
        PageData pageData = new PageData();
        pageData.setPageIndex(page.getNumber() + 1);
        pageData.setTotalCount((int) page.getTotalElements());
        pageData.setPageSize(page.getSize());
        List<Map<String, Object>> result = getStudentsResult(page.getContent());
        pageData.setStudentData(result);
        return pageData;
    }
}
