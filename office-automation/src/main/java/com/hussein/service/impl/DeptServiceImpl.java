package com.hussein.service.impl;

import com.hussein.domain.Dept;
import com.hussein.repository.DeptRepository;
import com.hussein.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: DeptServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 5:08 PM
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptRepository deptRepository;

    @Override
    public List<Dept> getAllDepts() {
        return deptRepository.findAll();
    }
}
