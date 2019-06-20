package com.cly.mara.controller;

import com.cly.mara.bean.UserInfoBean;
import com.cly.mara.service.UserInfoService;
import com.cly.mara.service.UserInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ManagementController {
    UserInfoService userInfoService = new UserInfoServiceImpl();
    UserInfoBean userInfoBean;

    @PostMapping(value = "/upload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file,@RequestParam(value = "uid") int uid, Model model) {
        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "//Users//cly//Desktop//WEB-INF//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imgSrc = "/"+fileName;
        model.addAttribute("imgSrc",fileName);
        return "management";
    }

}
