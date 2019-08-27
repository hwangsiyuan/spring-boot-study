package com.hussein.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Title: Book</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/27 7:35 PM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

    private String id;

    private String title;

    private String author;

    private BigDecimal price;

    private String image;
}
