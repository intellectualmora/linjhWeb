package com.cly.mara.controller;

import com.cly.mara.bean.PublicationBean;
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
    int leaderUid = 1;
    NewsService newsService = new NewsServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();
    PictureService pictureService = new PictureServiceImpl();
    PublicationService publicationService = new PublicationServiceImpl();


    List<NewsBean> newsBeanList = null;
    UserInfoBean userInfoBean = null;
    List<UserInfoBean> userInfoBeanList = null;
    List<PublicationBean> publicationBeanList = null;
    List<PictureBean> pictureBeanList = null;

    int pageNumber;
    int[] pageList;

    @GetMapping(value = "/index")
    public String getId (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
            switch (id){
                case 0:   //home
                    try {
                        newsBeanList = newsService.getRecentNews();
                        publicationBeanList = publicationService.getRecentPublicationList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("newsBeanList", newsBeanList);
                    model.addAttribute("publicationBeanList",publicationBeanList);
                    return "index";
                case 1:   //group
                    try {
                        userInfoBean =userInfoService.getUserInfo(leaderUid);
                        publicationBeanList = publicationService.getPublicationListByUid(leaderUid);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("userInfoBean", userInfoBean);
                    model.addAttribute("publicationBeanList", publicationBeanList);
                    return "leader";
                case 11:  //leader
                    try {
                        userInfoBean =userInfoService.getUserInfo(leaderUid);
                        publicationBeanList = publicationService.getPublicationListByUid(leaderUid);
                    } catch (Exception e) {
                    e.printStackTrace();
                    }

                    model.addAttribute("userInfoBean", userInfoBean);
                    model.addAttribute("publicationBeanList", publicationBeanList);
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
                        publicationBeanList = publicationService.getPublicationList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    pageNumber = (int)Math.ceil(publicationBeanList.size()/20.0);
                    pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("publicationBeanList", publicationBeanList);
                    model.addAttribute("page", 1);
                    model.addAttribute("pageList",pageList);
                    return "publication";
                case 4:  //resources
                    return "resources";
                case 5:  //news
                    try {
                        newsBeanList = newsService.getNewsList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    pageNumber = (int)Math.ceil(newsBeanList.size()/7.0);
                    pageList = new int[pageNumber];
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
                        publicationBeanList = publicationService.getRecentPublicationList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("newsBeanList", newsBeanList);
                    model.addAttribute("publicationBeanList",publicationBeanList);
                    return "index";
            }
    }


    @PostMapping("/index")
    public void search (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
        System.out.println(id);
    }


}