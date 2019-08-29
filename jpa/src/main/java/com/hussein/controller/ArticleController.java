package com.hussein.controller;

import com.hussein.bean.Article;
import com.hussein.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Title: ArticleController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 5:01 PM
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @GetMapping("/sort")
    public Iterable<Article> sortArticle() {
        return articleService.findAll(new Sort(Sort.Direction.DESC, "id"));
    }

    @GetMapping("/pager")
    public Page<Article> sortPagerArticle(int pageIndex) {
        return articleService.findAll(PageRequest.of(pageIndex - 1, 2, new Sort(Sort.Direction.DESC, "id")));
    }
}
