package com.cly.mara.controller;

import com.cly.mara.bean.BannerBean;
import com.cly.mara.bean.NewsBean;
import com.cly.mara.bean.PublicationBean;
import com.cly.mara.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String setDefault (Model model) {

        try {
            newsBeanList = newsService.getRecentNews();
            publicationBeanList = publicationService.getRecentPublicationList();
            bannerBeanList = bannerService.getRecentBannerBeanList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("bannerBeanList",bannerBeanList);
        model.addAttribute("newsBeanList", newsBeanList);
        model.addAttribute("publicationBeanList",publicationBeanList);
        return "index";
    }
}
