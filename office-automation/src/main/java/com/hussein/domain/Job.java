package com.hussein.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * <p>Title: Job</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/7 3:11 PM
 */
@Data
@Entity
@Table(name = "tb_oa_job")
public class Job implements Serializable {

    @Id
    @Column(name = "code", length = 100)
    private String code;

    /**
     * 职位名称
     */
    @Column(name = "name", length = 128)
    private String name;

    /**
     * 职位描述
     */
    @Column(name = "remark", length = 1024)
    private String remark;

}
