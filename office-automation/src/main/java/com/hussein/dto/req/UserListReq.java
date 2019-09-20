package com.hussein.dto.req;

import lombok.Data;

/**
 * <p>Title: UserListReq</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 11:26 AM
 */
@Data
public class UserListReq {

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String telephone;

    /**
     * 部门id
     */
    private String deptId;

    /**
     * 岗位编码
     */
    private String jobCode;

    /**
     * 页号
     */
    private Integer pageIndex;
}
