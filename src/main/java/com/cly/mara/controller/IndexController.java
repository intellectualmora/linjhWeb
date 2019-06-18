package com.cly.mara.controller;

import com.cly.mara.bean.NewsBean;
import com.cly.mara.bean.UserInfoBean;
import com.cly.mara.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 *
 */
@Controller
public class IndexController {
    /**
     *
     * @param id
     * @param model
     * @return
     */
    NewsService newsService = new NewsServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();
    PictureService pictureService = new PictureServiceImpl();
    ArticleService articleService = new ArticleServiceImpl();


    List<NewsBean> newsBeanList = null;
    UserInfoBean userInfoBean = null;
    List<UserInfoBean> userInfoBeanList = null;


    @GetMapping(value = "/index")
    public String getId (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
            switch (id){
                case 0:   //home
                    try {
                        newsBeanList = newsService.getRecentNews();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("newsBeanList", newsBeanList);
                    return "index";
                case 1:   //group
                    try {
                        UserInfoBean userInfoBean =userInfoService.getUserInfo(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("userInfoBean", userInfoBean);
                    return "leader";
                case 11:  //leader
                    try {
                        UserInfoBean userInfoBean =userInfoService.getUserInfo(0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("userInfoBean", userInfoBean);
                    return "leader";
                case 12:  // member
                    try {
                        userInfoBeanList =userInfoService.getUserInfoBeanList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("userInfoBeanList", userInfoBeanList);
                    return "member";
                case 13:  //picture

                    return "picture";
                case 14:   //alumni
                    return "alumni";
                case 2:  //research
                    return "research";
                case 3:  //publication
                    return "publication";
                case 4:  //resources
                    return "resources";
                case 5:  //news
                    try {
                        newsBeanList = newsService.getNewsList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("newsBeanList", newsBeanList);
                    return "news";
                case 6:  //contact
                    return "contact";
                case 7:  //login
                    return "login";
                default:
                    try {
                        newsBeanList = newsService.getRecentNews();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("newsBeanList", newsBeanList);
                    return "index";
            }
    }


    @PostMapping("/index")
    public void search (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
        System.out.println(id);
    }


}