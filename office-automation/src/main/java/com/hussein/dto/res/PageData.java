package com.hussein.dto.res;

import lombok.Data;

/**
 * <p>Title: PageData</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 11:42 AM
 */
@Data
public class PageData<T> {

    private Integer pageIndex;

    private Integer pageSize;

    private Integer totalCount;

    private T data;
}
