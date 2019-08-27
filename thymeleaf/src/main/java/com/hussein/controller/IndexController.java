package com.hussein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Title: IndexController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/27 4:10 PM
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }
}
