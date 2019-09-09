package com.hussein.dto.req;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * <p>Title: LoginReq</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/9 12:15 PM
 */
@Data
public class LoginReq {

    @NotBlank(message = "账号/邮箱不可为空")
    private String userId;

    @NotBlank(message = "密码不可为空")
    private String password;

    @NotBlank(message = "验证码不可为空")
    private String vcode;
}
