package com.hussein.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>Title: Module</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/7 3:53 PM
 */
@Data
@Entity
@Table(name = "tb_oa_module")
public class Module {

    @Id
    @Column(name = "code", length = 100)
    private String code;

    /**
     * 模块名称
     */
    @Column(name = "name", length = 128)
    private String name;

    /**
     * 操作链接
     */
    @Column(name = "url", length = 128)
    private String url;

    /**
     * 模块描述
     */
    @Column(name = "remark", length = 1024)
    private String remark;

    /**
     * 创建人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "creator", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "fk_oa_module_creator"))
    private User creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;


    /**
     * 修改人
     */
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(name = "modifier", referencedColumnName = "user_id", foreignKey = @ForeignKey(name = "fk_oa_module_modifier"))
    private User modifier;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyTime;
}
