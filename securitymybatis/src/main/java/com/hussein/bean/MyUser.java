package com.hussein.bean;

import lombok.Data;

/**
 * <p>Title: MyUser</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/6 10:35 AM
 */
@Data
public class MyUser {

    private Long id;

    private String loginName;

    private String password;

    private String userName;
}
