package com.hussein.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 * <p>Title: User</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/28 7:48 PM
 */
@Data
public class User implements Serializable {

    private String username;

    private MultipartFile headPortrait;
}
