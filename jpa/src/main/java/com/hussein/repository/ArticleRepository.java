package com.hussein.repository;

import com.hussein.bean.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * <p>Title: ArticleRepository</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 4:18 PM
 */
public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {
}
