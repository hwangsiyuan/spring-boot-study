package com.hussein.config;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * <p>Title: MySQL5DialectUTF8</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/5 2:28 PM
 */
public class MySQL5DialectUTF8 extends MySQL5Dialect {

    @Override
    public String getTableTypeString() {
        return "ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
