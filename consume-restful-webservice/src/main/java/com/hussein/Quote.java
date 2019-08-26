package com.hussein;

import lombok.Data;

/**
 * <p>Title: Quote</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/26 3:12 PM
 */
@Data
public class Quote {

    private String type;

    private Value value;

    @Data
    public static class Value{

        private Integer id;

        private String quote;
    }
}
