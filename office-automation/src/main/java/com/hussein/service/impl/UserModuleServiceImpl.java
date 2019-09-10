package com.hussein.service.impl;

import com.hussein.domain.Module;
import com.hussein.dto.res.UserModule;
import com.hussein.repository.ModuleRepository;
import com.hussein.repository.PopedomRepository;
import com.hussein.service.UserModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: UserModuleServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/10 2:16 PM
 */
@Service
public class UserModuleServiceImpl implements UserModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private PopedomRepository popedomRepository;

    @Override
    public List<UserModule> getUserPopedomModules(String userId) {
        List<UserModule> userModuleList = new ArrayList<>();
        List<String> moduleCodes = popedomRepository.getUserPopedomModuleCodes(userId);
        if (!ObjectUtils.isEmpty(moduleCodes)) {
            Map<Module, List<Module>> moduleListMap = new LinkedHashMap<>();
            moduleCodes.forEach(moduleCode -> {
                String firstModuleCode = moduleCode.substring(0, 4);
                Module module = moduleRepository.findById(firstModuleCode).get();
                module.setName(module.getName().replace("-", ""));
                List<Module> secondModuleList = new ArrayList<>();
                moduleListMap.putIfAbsent(module, secondModuleList);
                Module secondModule = moduleRepository.findById(moduleCode).get();
                secondModule.setName(secondModule.getName().replace("-", ""));
                secondModuleList.add(secondModule);
            });
            moduleListMap.forEach((k, v) -> {
                UserModule userModule = new UserModule();
                userModule.setFirstModule(k);
                userModule.setSecondModules(v);
                userModuleList.add(userModule);
            });
        }
        return userModuleList;
    }
}
