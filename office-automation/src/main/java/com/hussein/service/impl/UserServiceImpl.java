package com.hussein.service.impl;

import com.hussein.domain.User;
import com.hussein.dto.req.UserListReq;
import com.hussein.dto.res.PageData;
import com.hussein.repository.UserRepository;
import com.hussein.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/20 11:48 AM
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public PageData<List<User>> listUser(UserListReq req) {
        int pageIndex = req.getPageIndex() == null ? 0 : req.getPageIndex() - 1;
        Page<User> userPage = userRepository.findAll((Specification<User>) (root, cq, cb) -> {
            List<Predicate> predicateList = new ArrayList<>();
            if (!ObjectUtils.isEmpty(req.getName())) {
                predicateList.add(cb.like(root.get("name"), "%" + req.getName() + "%"));
            }
            if (!ObjectUtils.isEmpty(req.getTelephone())) {
                predicateList.add(cb.like(root.get("telephone"), "%" + req.getTelephone() + "%"));
            }
            if (!ObjectUtils.isEmpty(req.getDeptId())) {
                root.join("dept", JoinType.INNER);
                predicateList.add(cb.equal(root.get("dept").get("id"), req.getDeptId()));
            }
            if (!ObjectUtils.isEmpty(req.getJobCode())) {
                root.join("job", JoinType.INNER);
                predicateList.add(cb.equal(root.get("job").get("code"), req.getJobCode()));
            }
            return cq.where(predicateList.toArray(new Predicate[]{})).getRestriction();
        }, PageRequest.of(pageIndex, 10));
        PageData<List<User>> pageData = new PageData<>();
        pageData.setPageIndex(pageIndex);
        pageData.setPageSize(10);
        if (userPage == null) {
            pageData.setData(new ArrayList<>());
            pageData.setTotalCount(0);
        } else {
            pageData.setTotalCount((int) userPage.getTotalElements());
            List<User> userList = userPage.getContent().stream().map(u -> {
                if (u != null && u.getDept() != null) {
                    u.getDept().getName();
                }
                if (u != null && u.getJob() != null) {
                    u.getDept().getName();
                }
                return u;
            }).collect(Collectors.toList());
            pageData.setData(userList);
        }
        return pageData;
    }
}
