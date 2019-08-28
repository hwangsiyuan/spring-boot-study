package com.hussein;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: IndexController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/28 4:37 PM
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String eachTest(Model model) {
        System.out.println("welcome to jsp.");
        List<Book> bookList = new ArrayList<>();
        String[] bookNames = new String[]{"疯狂Ajax讲义", "struts2.1权威指南", "疯狂XML讲义"};
        String[] images = new String[]{"ajax.jpg", "struts.jpg", "xml.jpg"};
        String[] authors = new String[]{"李刚", "李大刚", "李小刚"};
        BigDecimal[] prices = new BigDecimal[]{new BigDecimal("1.1"), new BigDecimal("2.1"), new BigDecimal("3.5")};
        for (int i = 0; i < bookNames.length; i++) {
            bookList.add(Book.builder().id(String.valueOf(i)).image(images[i]).title(bookNames[i]).author(authors[i]).price(prices[i]).build());
        }
        model.addAttribute("username", "kitty");
        model.addAttribute("books", bookList);
        return "index";
    }
}
