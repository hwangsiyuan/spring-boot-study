package com.hussein.service;

import com.hussein.domain.Job;

import java.util.List;

/**
 * <p>Title: JobService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 5:12 PM
 */
public interface JobService {

    /**
     * 获取岗位列表
     *
     * @return
     */
    List<Job> getAllJobs();
}
