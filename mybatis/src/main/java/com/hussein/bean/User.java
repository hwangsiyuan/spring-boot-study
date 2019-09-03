package com.hussein.bean;

import lombok.Data;

/**
 * <p>Title: User</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 1:56 PM
 */
@Data
public class User {

    private Long id;

    private String loginName;

    private String password;

    private String userName;
}
