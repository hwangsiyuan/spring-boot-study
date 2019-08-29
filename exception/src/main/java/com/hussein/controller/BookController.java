package com.hussein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Title: BookController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/29 10:06 AM
 */
@Controller
public class BookController extends BaseController {

    @GetMapping("/find")
    public String find() {
        int i = 5 / 0;
        return "success";
    }
}
