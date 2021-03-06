package com.hussein.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title: DeptDto</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 7:29 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptDto {

    private Long id;

    /**
     * 部门名称
     */
    private String name;
}
