package com.hussein.service;

import com.hussein.dto.res.UserModule;

import java.util.List;

/**
 * <p>Title: UserModuleService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/10 2:15 PM
 */
public interface UserModuleService {

    List<UserModule> getUserPopedomModules(String userId);
}
