package com.hussein.service;

import com.hussein.bean.Article;
import com.hussein.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/**
 * <p>Title: ArticleService</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 4:27 PM
 */
@Service
public class ArticleService {

    @Autowired
    ArticleRepository repository;

    public Iterable<Article> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    public Page<Article> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
