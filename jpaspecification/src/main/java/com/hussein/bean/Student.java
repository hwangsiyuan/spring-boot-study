package com.hussein.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * <p>Title: Student</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/2 7:33 PM
 */
@Data
@Entity
@Table(name = "tb_student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Clazz.class)
    @JoinColumn(name = "clazzId",referencedColumnName = "id")
    private Clazz clazz;
}
