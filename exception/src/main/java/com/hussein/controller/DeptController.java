package com.hussein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Title: DeptController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 10:17 AM
 */
@Controller
public class DeptController {

    @GetMapping("/add")
    public String add(String deptName) {
        if (deptName == null) {
            throw new RuntimeException("部门名称不可为空");
        }
        return "success";
    }
}
