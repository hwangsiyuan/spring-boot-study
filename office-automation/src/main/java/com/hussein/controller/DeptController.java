package com.hussein.controller;

import com.hussein.domain.Dept;
import com.hussein.domain.Job;
import com.hussein.dto.res.DeptDto;
import com.hussein.dto.res.JobDto;
import com.hussein.service.DeptService;
import com.hussein.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>Title: DeptController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 4:57 PM
 */
@Controller
@RequestMapping("/identity/dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private JobService jobService;

    @RequestMapping(value = "/getAllDeptsAndJobsAjax", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public Map<String, Object> getAllDeptsAndJobsAjax() {
        List<Dept> depts = deptService.getAllDepts();
        List<Job> jobs = jobService.getAllJobs();
        Map<String, Object> result = new HashMap<>();
        result.put("depts", ObjectUtils.isEmpty(depts) ? new ArrayList<>() : depts.stream().map(d -> DeptDto.builder().id(d.getId()).name(d.getName()).build()).collect(Collectors.toList()));
        result.put("jobs", ObjectUtils.isEmpty(jobs) ? new ArrayList<>() : jobs.stream().map(j -> JobDto.builder().code(j.getCode()).name(j.getName()).build()).collect(Collectors.toList()));
        return result;
    }
}
