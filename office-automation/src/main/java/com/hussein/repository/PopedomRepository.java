package com.hussein.repository;

import com.hussein.domain.Popedom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * <p>Title: PopedomRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/7 5:22 PM
 */
public interface PopedomRepository extends JpaRepository<Popedom, Long> {

    @Query("select distinct p.module.code from Popedom p where p.role.id in (select r.id from Role r inner join r.users u where u.userId=?1) order by p.module.code desc")
    List<String> getUserPopedomModuleCodes(String userId);
}
