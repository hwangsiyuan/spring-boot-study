package com.hussein.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title: LoginRes</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/9 12:22 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRes {

    private int status;

    private String tip;
}
