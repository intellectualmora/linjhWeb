package com.cly.mara.controller;

import com.cly.mara.bean.PublicationBean;
import com.cly.mara.service.PublicationService;
import com.cly.mara.service.PublicationServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PublicationController {
    PublicationService publicationService = new PublicationServiceImpl();
    List<PublicationBean> publicationBeanList = null;
    @GetMapping(value = "/publicationPage")
    public String getPublicationPage(@RequestParam(name = "page", required = false, defaultValue = "1") int page,@RequestParam(name = "year", required = false, defaultValue = "0") int year, Model model) {
        try {
            if(year ==0) {
                publicationBeanList = publicationService.getPublicationList();
            }else{
                publicationBeanList = publicationService.getPublicationList(year);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pageNumber = (int)Math.ceil(publicationBeanList.size()/20.0);
        int[] pageList = new int[pageNumber];
        for(int i =0;i<pageNumber;i++){
            pageList[i] = i+1;
        }
        model.addAttribute("publicationBeanList", publicationBeanList.subList((page-1)*20,Math.min(page*20,publicationBeanList.size())));
        model.addAttribute("page",page);
        model.addAttribute("pageList",pageList);
        model.addAttribute("year",year);
        return "publication";
    }

    @GetMapping(value = "/publicationInfo")
    public String getPublication(@RequestParam(name = "pid", required = false, defaultValue = "0") int pid, Model model) {
        PublicationBean publicationBean = null;
        try {
            publicationBean = publicationService.getPublication(pid);
        }catch (Exception e){
            e.printStackTrace();
        }
        model.addAttribute("publicationBean", publicationBean);
        return "publicationInfo";
    }
}
