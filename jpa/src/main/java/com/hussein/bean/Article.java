package com.hussein.bean;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>Title: Article</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 4:05 PM
 */
@Data
@Entity
@Table(name = "tb_article")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 供应商
     */
    private String supplier;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 出版社
     */
    private String locality;

    /**
     * 图片
     */
    private String image;

    /**
     * 描述
     */
    private String description;

    /**
     * 库存数量
     */
    private Integer storage;

    /**
     * 创建时间
     */
    private Date createTime;
}
