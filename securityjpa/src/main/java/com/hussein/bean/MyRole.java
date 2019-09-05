package com.hussein.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * <p>Title: MyRole</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/5 1:55 PM
 */
@Data
@Entity
@Table(name = "tb_role")
public class MyRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authority;
}
