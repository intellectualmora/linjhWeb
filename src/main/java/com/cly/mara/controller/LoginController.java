package com.cly.mara.controller;

import com.cly.mara.bean.UserInfoBean;
import com.cly.mara.service.UserInfoService;
import com.cly.mara.service.UserInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
UserInfoService userInfoService = new UserInfoServiceImpl();
@PostMapping("/check")
public String login (@RequestParam(name="userName") String userName, @RequestParam(name="password") String password, Model model, HttpServletRequest request) {

    UserInfoBean userInfoBean;
    try {
        userInfoBean = userInfoService.login(userName,password);
    } catch (Exception e) {
        model.addAttribute("error",true);
        return "login";
    }
    if(userInfoBean == null){
        model.addAttribute("error",true);
        return "login";
    }else {
        HttpSession session =request.getSession();//这就是session的创建
        session.setAttribute("userInfoBean",userInfoBean);
        model.addAttribute("userInfoBean",userInfoBean);
        model.addAttribute("imgSrc","null");
        return "management";
    }
}

}
