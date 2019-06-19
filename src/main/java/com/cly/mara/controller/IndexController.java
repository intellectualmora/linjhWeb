package com.cly.mara.controller;

import com.cly.mara.bean.PulicationBean;
import com.cly.mara.bean.NewsBean;
import com.cly.mara.bean.PictureBean;
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
    PublicationService publicationService = new PublicationServiceImpl();


    List<NewsBean> newsBeanList = null;
    UserInfoBean userInfoBean = null;
    List<UserInfoBean> userInfoBeanList = null;
    List<PulicationBean> pulicationBeanList = null;
    List<PictureBean> pictureBeanList = null;


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
                        userInfoBean =userInfoService.getUserInfo(0);
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    System.out.println(userInfoBean.getAddress());
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
                    try {
                        pictureBeanList =pictureService.getPictureBeanList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("pictureBeanList", pictureBeanList);
                    return "picture";
                case 14:   //alumni
                    return "alumni";
                case 2:  //research
                    return "research";
                case 3:  //publication
                    try {
                        pulicationBeanList = publicationService.getArticleList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("articleBeanList", pulicationBeanList);
                    return "publication";
                case 4:  //resources

                    return "resources";
                case 5:  //news
                    try {
                        newsBeanList = newsService.getNewsList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    int pageNumber = (int)Math.ceil(newsBeanList.size()/7.0);
                    int[] pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("newsBeanList", newsBeanList.subList(0,Math.min(7,newsBeanList.size())));
                    model.addAttribute("page", 1);
                    model.addAttribute("pageList",pageList);
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