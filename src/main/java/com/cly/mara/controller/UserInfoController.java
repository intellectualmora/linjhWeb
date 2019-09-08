package com.cly.mara.controller;

import com.cly.mara.bean.*;
import com.cly.mara.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserInfoController {
    UserInfoService userInfoService = new UserInfoServiceImpl();
    PublicationService publicationService = new PublicationServiceImpl();
    EducationService educationService = new EducationServiceImpl();
    ExperienceService experienceService = new ExperienceServiceImpl();
    AwardService awardService = new AwardServiceImpl();
    InterestService interestService = new InterestServiceImpl();

    UserInfoBean userInfoBean = null;
    List<PublicationBean> publicationBeanList = null;
    List<EducationBean> educationBeanList = null;
    List<ExperienceBean> experienceBeanList = null;
    List<InterestBean> interestBeanList = null;
    List<AwardBean> awardBeanList = null;
    @GetMapping(value = "/memberInfo")
    public String getNewsInfo(@RequestParam(name = "uid", required = false, defaultValue = "0") int uid, Model model, HttpServletRequest request) {
        UserInfoBean newsBean = null;
        boolean language = false;
        HttpSession session =request.getSession();//这就是session的创建
        try{
            language = (boolean)session.getAttribute("language");
        }catch (Exception e){

        }
        try {
            try {
                userInfoBean =userInfoService.getUserInfo(uid);
                publicationBeanList = publicationService.getPublicationListByUid(uid);
                educationBeanList = educationService.getEducationList(uid);
                experienceBeanList = experienceService.getExperienceBeanList(uid);
                awardBeanList = awardService.getAwardBeanList(uid);
                interestBeanList = interestService.getInterestBeanList(uid);
            } catch (Exception e) {
                e.printStackTrace();
            }
            model.addAttribute("language",language);
            model.addAttribute("userInfoBean", userInfoBean);
            model.addAttribute("publicationBeanList", publicationBeanList);
            model.addAttribute("educationBeanList",educationBeanList);
            model.addAttribute("experienceBeanList",experienceBeanList);
            model.addAttribute("awardBeanList",awardBeanList);
            model.addAttribute("interestBeanList",interestBeanList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "memberInfo";
    }
}
