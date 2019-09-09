package com.hussein.controller;

import com.hussein.utils.CreateImageCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>Title: VerifyCodeController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/9/9 10:47 AM
 */
@RestController
@RequestMapping("/oa")
public class VerifyCodeController {

    @GetMapping("/createCode")
    public String verifyCode(HttpSession session, HttpServletResponse response) {
        CreateImageCode createImageCode = new CreateImageCode(60, 22);
        BufferedImage img = createImageCode.getBuffImg();
        response.setContentType("images/jpeg");
        try {
            ImageIO.write(img, "jpeg", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        session.setAttribute("verify_session", createImageCode.getCode());
        return null;
    }
}
