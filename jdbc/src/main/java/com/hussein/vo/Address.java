package com.hussein.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>Title: Address</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/27 10:19 AM
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String id;

    private String address;

    private String addressDetail;
}
