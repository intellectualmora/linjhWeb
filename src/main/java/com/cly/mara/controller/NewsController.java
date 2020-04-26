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
        boolean language = false;
        if(year ==202){
            year = 2020;
        }
        HttpSession session =request.getSession();//这就是session的创建
        Object temp_lan = session.getAttribute("language");
        if(temp_lan!=null) {
            language = (boolean) temp_lan;
        }
        if(page!=1){
            boolean flag = true;
            Object temp = session.getAttribute("newsBeanList");
            if(temp!=null){
                newsBeanList = (List<NewsBean>) temp;
            }else{
                flag=false;
            }
            if(flag){
                if(newsBeanList.size()>(page-1)*pagesize){
                    int pageNumber = (int)Math.ceil(newsBeanList.size()/fpagesize);
                    int[] pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("newsBeanList", newsBeanList.subList((page-1)*pagesize,Math.min(page*pagesize,newsBeanList.size())));
                    model.addAttribute("page",page);
                    model.addAttribute("pageList",pageList);
                    model.addAttribute("year",year);
                    return "news";
                }
            }else{
                try {
                    if(year == 0) {
                        newsBeanList = newsService.getNewsList();
                    }else{
                        newsBeanList = newsService.getNewsList(year);
                    }
                    session.setAttribute("newsBeanList",newsBeanList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(newsBeanList.size()>(page-1)*pagesize){
                    int pageNumber = (int)Math.ceil(newsBeanList.size()/fpagesize);
                    int[] pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("newsBeanList", newsBeanList.subList((page-1)*pagesize,Math.min(page*pagesize,newsBeanList.size())));
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
        model.addAttribute("page",page);
        model.addAttribute("pageList",pageList);
        model.addAttribute("year",year);
        return "news";
    }
    @GetMapping(value = "/newsInfo")
    public String getNewsInfo(@RequestParam(name = "nid", required = false, defaultValue = "0") int nid, Model model,HttpServletRequest request) {
        boolean language = false;
        HttpSession session =request.getSession();//这就是session的创建
        Object temp = session.getAttribute("language");
        if(temp != null) {
            language = (boolean)temp;
        }
        NewsBean newsBean = null;
        try {
            newsBean = newsService.getNews(nid);
            model.addAttribute("newsBean",newsBean);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("language",language);
        return "newsInfo";
    }
}