package com.hussein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>Title: MainController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/27 4:20 PM
 */
@Controller
public class MainController {

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
