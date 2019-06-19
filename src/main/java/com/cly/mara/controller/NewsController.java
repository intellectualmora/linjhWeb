package com.cly.mara.controller;

import com.cly.mara.bean.NewsBean;
import com.cly.mara.service.NewsService;
import com.cly.mara.service.NewsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class NewsController {
    NewsService newsService = new NewsServiceImpl();
    List<NewsBean> newsBeanList = null;
    @GetMapping(value = "/news")
    public String getNews(@RequestParam(name = "year", required = false, defaultValue = "2019") int year, Model model) {
        return "news";
    }
    @GetMapping(value = "/newsPage")
    public String getNewsPage(@RequestParam(name = "page", required = false, defaultValue = "1") int page, Model model) {
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
        model.addAttribute("newsBeanList", newsBeanList.subList((page-1)*7,Math.min(page*7,newsBeanList.size())));
        model.addAttribute("page",page);
        model.addAttribute("pageList",pageList);
        return "news";
    }
    @GetMapping(value = "/newsInfo")
    public String getNewsInfo(@RequestParam(name = "nid", required = false, defaultValue = "0") int nid, Model model) {
        NewsBean newsBean = null;
        try {
            newsBean = newsService.getNews(nid);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("newsBean",newsBean);
        return "newsInfo";
    }
}