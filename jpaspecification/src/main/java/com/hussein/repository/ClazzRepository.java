package com.hussein.repository;

import com.hussein.bean.Clazz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * <p>Title: ClazzRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/2 7:37 PM
 */
public interface ClazzRepository extends JpaRepository<Clazz,Long>, JpaSpecificationExecutor<Clazz> {
}
