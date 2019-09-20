package com.hussein.service;

import com.hussein.domain.Dept;

import java.util.List;

/**
 * <p>Title: DeptService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 5:01 PM
 */
public interface DeptService {

    /**
     * 部门列表
     *
     * @return
     */
    List<Dept> getAllDepts();
}
