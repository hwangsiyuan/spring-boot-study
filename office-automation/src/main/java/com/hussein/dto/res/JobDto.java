package com.hussein.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title: JobDto</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 7:30 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JobDto {

    private String code;

    /**
     * 职位名称
     */
    private String name;
}
