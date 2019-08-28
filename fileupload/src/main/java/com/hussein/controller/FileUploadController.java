package com.hussein.controller;

import com.hussein.request.User;
import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * <p>Title: FileUploadController</p>
 * <p>Description: </p>
 * <p>Company: www.hussein.com</p>
 *
 * @author hwangsy
 * @date 2019/8/28 7:14 PM
 */
@Controller
public class FileUploadController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/registerForm")
    public String registerForm() {
        return "registerForm";
    }

    @PostMapping("/upload")
    public String upload(HttpServletRequest request, @RequestParam("description") String description, @RequestParam("file") MultipartFile file) {
        System.out.println(description);
        if (!file.isEmpty()) {
            // 上传文件路径
            String path = request.getServletContext().getRealPath("/upload/");
            System.out.println("path = " + path);
            // 上传文件名
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            // 判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文件当中
            try {
                file.transferTo(new File(path + File.separator + filename));
                return "success";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "error";
    }

    @PostMapping("/register")
    public String register(HttpServletRequest request, @ModelAttribute User user, Model model) {
        // 接收参数username
        System.out.println("username = " + user.getUsername());
        // 如果文件不为空，写入上传路径
        if (!user.getHeadPortrait().isEmpty()) {
            // 上传文件路径
            String path = request.getServletContext().getRealPath("/upload/");
            System.out.println("path = " + path);
            // 上传文件名
            String filename = user.getHeadPortrait().getOriginalFilename();
            File filepath = new File(path, filename);
            // 判断路径是否存在，如果不存在就创建一个
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            // 将上传文件保存到一个目标文件当中
            try {
                user.getHeadPortrait().transferTo(new File(path + File.separator + filename));
                // 将用户添加到model
                model.addAttribute("user", user);
                return "userInfo";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "error";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, @RequestParam("filename") String filename, @RequestHeader("User-Agent") String userAgent, Model model) {
        File file = new File(request.getServletContext().getRealPath("/upload/") + File.separator + filename);
        ResponseEntity.BodyBuilder builder = ResponseEntity.ok();
        builder.contentLength(file.length());
        try {
            filename = URLEncoder.encode(filename, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (userAgent.indexOf("MSIE") > 0) {
            builder.header("Content-Disposition", "attachment;filename=" + filename);
        } else {
            builder.header("Content-Disposition", "attachment;filename*=UTF-8''" + filename);
        }
        try {
            return builder.body(FileUtils.readFileToByteArray(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
