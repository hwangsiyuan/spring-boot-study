package com.hussein.controller;

import com.hussein.vo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: ThymeleafController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/27 6:00 PM
 */
@Controller
public class ThymeleafController {

    @GetMapping("regexptest")
    public String regexpTest(HttpServletRequest request, HttpSession session) {
        request.setAttribute("book", "如何一句话结束聊天话题");
        session.setAttribute("school", "中央戏精学院");
        session.getServletContext().setAttribute("name", "戏精本精");
        return "success1";
    }

    @GetMapping("iftest")
    public String ifTest(WebRequest request) {
        request.setAttribute("username", "我太难了", WebRequest.SCOPE_REQUEST);
        request.setAttribute("age", "20", WebRequest.SCOPE_REQUEST);
        request.setAttribute("address", "我站在山岗上", WebRequest.SCOPE_REQUEST);
        request.setAttribute("role", "admin", WebRequest.SCOPE_REQUEST);
        return "success2";
    }

    @GetMapping("eachtest")
    public String eachTest(WebRequest request) {
        List<Book> bookList = new ArrayList<>();
        String[] bookNames = new String[]{"疯狂Ajax讲义", "struts2.1权威指南", "疯狂XML讲义"};
        String[] images = new String[]{"ajax.jpg", "struts.jpg", "xml.jpg"};
        String[] authors = new String[]{"李刚", "李大刚", "李小刚"};
        BigDecimal[] prices = new BigDecimal[]{new BigDecimal("1.1"), new BigDecimal("2.1"), new BigDecimal("3.5")};
        for (int i = 0; i < bookNames.length; i++) {
            bookList.add(Book.builder().id(String.valueOf(i)).image(images[i]).title(bookNames[i]).author(authors[i]).price(prices[i]).build());
        }
        request.setAttribute("books", bookList, WebRequest.SCOPE_REQUEST);
        return "success3";
    }
}
