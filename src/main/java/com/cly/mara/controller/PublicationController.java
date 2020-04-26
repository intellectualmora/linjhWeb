package com.cly.mara.controller;

import com.cly.mara.bean.PublicationBean;
import com.cly.mara.service.PublicationService;
import com.cly.mara.service.PublicationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PublicationController {
    PublicationService publicationService = new PublicationServiceImpl();
    List<PublicationBean> publicationBeanList = null;
    int pagesize = 20;
    double fpagesize = 20.0;
    @GetMapping(value = "/publicationPage")
    public String getPublicationPage(@RequestParam(name = "page", required = false, defaultValue = "1") int page, @RequestParam(name = "year", required = false, defaultValue = "0") int year, Model model, HttpServletRequest request) {
        boolean language = false;
        if(year== 202){
            year = 2020;
        }
        HttpSession session =request.getSession();//这就是session的创建
        Object temp_lan = session.getAttribute("language");
        if(temp_lan!=null) {
            language = (boolean) temp_lan;
        }
        if(page!=1){
            boolean flag = true;
            Object temp = session.getAttribute("publicationBeanList");
            if(temp != null){
                publicationBeanList = (List<PublicationBean>) temp;
            }else {
                System.out.println("temp is null");
                flag = false;
            }
            if(flag){
                if(publicationBeanList.size()>(page-1)*pagesize){
                    int pageNumber = (int)Math.ceil(publicationBeanList.size()/fpagesize);
                    int[] pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("publicationBeanList", publicationBeanList.subList((page-1)*pagesize,Math.min(page*pagesize,publicationBeanList.size())));
                    model.addAttribute("page",page);
                    model.addAttribute("pageList",pageList);
                    model.addAttribute("year",year);
                    return "publication";
                }
            }else{
                try {
                    if(year == 0) {
                        publicationBeanList = publicationService.getPublicationList();
                    }else{
                        publicationBeanList = publicationService.getPublicationList(year);
                    }
                    session.setAttribute("publicationBeanList",publicationBeanList);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(publicationBeanList.size()>(page-1)*pagesize){
                    int pageNumber = (int)Math.ceil(publicationBeanList.size()/fpagesize);
                    int[] pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("publicationBeanList", publicationBeanList.subList((page-1)*pagesize,Math.min(page*pagesize,publicationBeanList.size())));
                    model.addAttribute("page",page);
                    model.addAttribute("pageList",pageList);
                    model.addAttribute("year",year);
                    return "publication";
                }
            }
        }
        try {
            if(year == 0) {
                publicationBeanList = publicationService.getPublicationList();
            }else{
                publicationBeanList = publicationService.getPublicationList(year);
            }
            session.setAttribute("publicationBeanList",publicationBeanList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pageNumber = (int)Math.ceil(publicationBeanList.size()/fpagesize);
        int[] pageList = new int[pageNumber];
        for(int i =0;i<pageNumber;i++){
            pageList[i] = i+1;
        }
        model.addAttribute("language",language);
        model.addAttribute("publicationBeanList", publicationBeanList.subList(0,Math.min(pagesize,publicationBeanList.size())));
        model.addAttribute("page",page);
        model.addAttribute("pageList",pageList);
        model.addAttribute("year",year);
        return "publication";
    }

    @GetMapping(value = "/publicationInfo")
    public String getPublication(@RequestParam(name = "pid", required = false, defaultValue = "0") int pid, Model model,HttpServletRequest request) {
        PublicationBean publicationBean = null;
        boolean language =false;
        HttpSession session =request.getSession();//这就是session的创建
        Object temp = session.getAttribute("language");
        if(temp != null){
            language = (boolean) temp;
        }
        try {
            publicationBean = publicationService.getPublication(pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("language",language);
        model.addAttribute("publicationBean", publicationBean);
        return "publicationInfo";
    }
}
