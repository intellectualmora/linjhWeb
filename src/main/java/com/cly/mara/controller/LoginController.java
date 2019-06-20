package com.cly.mara.controller;

import com.cly.mara.bean.UserInfoBean;
import com.cly.mara.service.UserInfoService;
import com.cly.mara.service.UserInfoServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
UserInfoService userInfoService = new UserInfoServiceImpl();
@PostMapping("/check")
public String login ( @RequestParam(name="userName") String userName, @RequestParam(name="password") String password, Model model) {

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
        model.addAttribute("userInfoBean",userInfoBean);
        model.addAttribute("imgSrc","null");
        return "management";
    }
}

}
