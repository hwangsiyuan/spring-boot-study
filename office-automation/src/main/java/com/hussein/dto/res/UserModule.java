package com.hussein.dto.res;

import com.hussein.domain.Module;
import lombok.Data;

import java.util.List;

/**
 * <p>Title: UserModule</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/10 2:12 PM
 */
@Data
public class UserModule {

    private Module firstModule;

    private List<Module> secondModules;
}
