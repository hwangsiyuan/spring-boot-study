package com.hussein.service;

import com.hussein.domain.User;
import com.hussein.dto.req.UserListReq;
import com.hussein.dto.res.PageData;

import java.util.List;

/**
 * <p>Title: UserService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 11:48 AM
 */
public interface UserService {

    PageData<List<User>> listUser(UserListReq req);
}
