package com.hussein.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: ClazzObject</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/30 5:42 PM
 */
@Data
@Entity
@Table(name = "tb_clazz")
public class Clazz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 班级名
     */
    private String name;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Student.class, mappedBy = "clazz")
    private Set<Student> students = new HashSet<>();
}
