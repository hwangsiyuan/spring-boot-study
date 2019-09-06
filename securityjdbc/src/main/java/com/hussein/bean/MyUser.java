package com.hussein.bean;

import lombok.Data;

import java.util.List;

/**
 * <p>Title: MyUser</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/6 12:35 PM
 */
@Data
public class MyUser {

    private Long id;

    private String loginName;

    private String password;

    private String userName;

    private List<MyRole> roles;
}
