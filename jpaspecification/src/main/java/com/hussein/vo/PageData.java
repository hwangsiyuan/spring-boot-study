package com.hussein.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: PageData</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/3 11:21 AM
 */
@Data
public class PageData {

    private int pageIndex;

    private int totalCount;

    private  int pageSize;

    private List<Map<String,Object>> studentData = new ArrayList<>();
}
