package com.cly.mara.controller;

import com.cly.mara.bean.NewsBean;
import com.cly.mara.bean.PublicationBean;
import com.cly.mara.service.NewsService;
import com.cly.mara.service.NewsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NewsController {
    NewsService newsService = new NewsServiceImpl();
    List<NewsBean> newsBeanList = null;
    int pagesize = 7;
    double fpagesize = 7.0;
    @GetMapping(value = "/newsPage")
    public String getNewsPage(@RequestParam(name = "page", required = false, defaultValue = "1") int page, @RequestParam(name = "year", required = false, defaultValue = "0") int year, Model model, HttpServletRequest request) {
        if(page!=1){
            boolean flag = true;
            HttpSession session = request.getSession();
            try {
                newsBeanList = (List<NewsBean>) session.getAttribute("newsBeanList");
            }catch (Exception e){
                System.err.println(e.toString());
                flag = false;
            }
            if(flag && newsBeanList!=null){
                if(newsBeanList.size()>(page-1)*pagesize){
                    int pageNumber = (int)Math.ceil(newsBeanList.size()/fpagesize);
                    int[] pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("newsBeanList", newsBeanList.subList((page-1)*pagesize,Math.min(page*7,newsBeanList.size())));
                    model.addAttribute("page",page);
                    model.addAttribute("pageList",pageList);
                    model.addAttribute("year",year);
                    return "news";
                }
            }
        }
        try {
            if(year == 0) {
                newsBeanList = newsService.getNewsList();
            }else{
                newsBeanList = newsService.getNewsList(year);
            }
            HttpSession session = request.getSession();
            session.setAttribute("newsBeanList",newsBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pageNumber = (int)Math.ceil(newsBeanList.size()/fpagesize);
        int[] pageList = new int[pageNumber];
        for(int i =0;i<pageNumber;i++){
            pageList[i] = i+1;
        }
        model.addAttribute("newsBeanList", newsBeanList.subList(0,Math.min(pagesize,newsBeanList.size())));
        model.addAttribute("page",1);
        model.addAttribute("pageList",pageList);
        model.addAttribute("year",year);
        return "news";
    }
    @GetMapping(value = "/newsInfo")
    public String getNewsInfo(@RequestParam(name = "nid", required = false, defaultValue = "0") int nid, Model model) {
        NewsBean newsBean = null;
        try {
            newsBean = newsService.getNews(nid);
            model.addAttribute("newsBean",newsBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "newsInfo";
    }
}