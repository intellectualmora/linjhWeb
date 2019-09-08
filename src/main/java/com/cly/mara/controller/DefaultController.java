package com.cly.mara.controller;

import com.cly.mara.bean.BannerBean;
import com.cly.mara.bean.NewsBean;
import com.cly.mara.bean.PublicationBean;
import com.cly.mara.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
public class DefaultController {
    NewsService newsService = new NewsServiceImpl();
    PublicationService publicationService = new PublicationServiceImpl();
    BannerService bannerService = new BannerServiceImpl();

    List<NewsBean> newsBeanList = null;
    List<PublicationBean> publicationBeanList = null;
    List<BannerBean> bannerBeanList = null;

    @RequestMapping(value = "/")
    public String setDefault (Model model, HttpServletRequest request) {
        boolean language = true;
        HttpSession session =request.getSession();//这就是session的创建
        try{
            language = (boolean)session.getAttribute("language");
        }catch (Exception e){

        }
        try {
            newsBeanList = newsService.getRecentNews();
            publicationBeanList = publicationService.getRecentPublicationList();
            bannerBeanList = bannerService.getRecentBannerBeanList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("language",language);
        model.addAttribute("language",language);
        model.addAttribute("bannerBeanList",bannerBeanList);
        model.addAttribute("newsBeanList", newsBeanList);
        model.addAttribute("publicationBeanList",publicationBeanList);
        return "index";
    }
}
