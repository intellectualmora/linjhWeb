package com.cly.mara.controller;

import com.cly.mara.bean.NewsBean;
import com.cly.mara.service.NewsService;
import com.cly.mara.service.NewsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
public class DefaultController {
    @RequestMapping(value = "/")
    public String setDefault (Model model) {
        NewsService newsService = new NewsServiceImpl();
        List<NewsBean> newsBeanList = null;
        try {
            newsBeanList = newsService.getRecentNews();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("newsBeanList", newsBeanList);
        return "index";
    }
}
