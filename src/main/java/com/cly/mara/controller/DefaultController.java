package com.cly.mara.controller;

import com.cly.mara.bean.NewsBean;
import com.cly.mara.bean.PublicationBean;
import com.cly.mara.service.NewsService;
import com.cly.mara.service.NewsServiceImpl;
import com.cly.mara.service.PublicationService;
import com.cly.mara.service.PublicationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class DefaultController {
    @RequestMapping(value = "/")
    public String setDefault (Model model) {
        NewsService newsService = new NewsServiceImpl();
        PublicationService publicationService = new PublicationServiceImpl();
        List<NewsBean> newsBeanList = null;
        List<PublicationBean> publicationBeanList = null;
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
