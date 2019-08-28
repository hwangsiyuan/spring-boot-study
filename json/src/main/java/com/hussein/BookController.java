package com.hussein;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: BookController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/28 5:34 PM
 */
@RestController
public class BookController {

    @PostMapping("/findBook")
    public Book findBook(@RequestBody Book book) {
        System.out.println(book);
        book.setImage("SpringMyBatis.jpg");
        book.setAuthor("我太难了");
        book.setRemark("轻量级框架开发方式");
        book.setPrice(new BigDecimal("52.50"));
        return book;
    }

    @PostMapping("/findBooks")
    public List<Book> findBooks() {
        List<Book> bookList = new ArrayList<>();
        String[] bookNames = new String[]{"疯狂Ajax讲义", "struts2.1权威指南", "疯狂XML讲义"};
        String[] images = new String[]{"ajax.jpg", "struts.jpg", "xml.jpg"};
        String[] authors = new String[]{"李刚", "李大刚", "李小刚"};
        BigDecimal[] prices = new BigDecimal[]{new BigDecimal("1.1"), new BigDecimal("2.1"), new BigDecimal("3.5")};
        for (int i = 0; i < bookNames.length; i++) {
            bookList.add(Book.builder().id(i).image(images[i]).name(bookNames[i]).remark(bookNames[i]).author(authors[i]).price(prices[i]).build());
        }
        return bookList;
    }
}
