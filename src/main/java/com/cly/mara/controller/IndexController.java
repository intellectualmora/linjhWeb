package com.cly.mara.controller;

import com.cly.mara.bean.*;
import com.cly.mara.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 *
 */
@Controller
public class IndexController {
    /**
     *
     * @param id
     * @param model
     * @return
     */
    int leaderUid = 1;
    NewsService newsService = new NewsServiceImpl();
    UserInfoService userInfoService = new UserInfoServiceImpl();
    PictureService pictureService = new PictureServiceImpl();
    PublicationService publicationService = new PublicationServiceImpl();
    EducationService educationService = new EducationServiceImpl();
    ExperienceService experienceService = new ExperienceServiceImpl();
    AwardService awardService = new AwardServiceImpl();
    InterestService interestService = new InterestServiceImpl();
    BannerService bannerService = new BannerServiceImpl();
    AlumniService alumniService = new AlumniServiceImpl();

    List<NewsBean> newsBeanList = null;
    UserInfoBean userInfoBean = null;
    List<UserInfoBean> userInfoBeanList = null;
    List<PublicationBean> publicationBeanList = null;
    List<PictureBean> pictureBeanList = null;
    List<EducationBean> educationBeanList = null;
    List<ExperienceBean> experienceBeanList = null;
    List<InterestBean> interestBeanList = null;
    List<AwardBean> awardBeanList = null;
    List<BannerBean> bannerBeanList = null;
    List<AlumniBean> alumniBeanList = null;

    int pageNumber;
    int[] pageList;

    @GetMapping(value = "/index")
    public String getId (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model, HttpServletRequest request) {
        boolean language = true;
        HttpSession session =request.getSession();//这就是session的创建

        try{
            language = (boolean)session.getAttribute("language");

        }catch (Exception e){


        }
        switch (id){
                case 0:   //home
                    try {
                        newsBeanList = newsService.getRecentNews();
                        publicationBeanList = publicationService.getRecentPublicationList();
                        bannerBeanList = bannerService.getRecentBannerBeanList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("bannerBeanList",bannerBeanList);
                    model.addAttribute("newsBeanList", newsBeanList);
                    model.addAttribute("publicationBeanList",publicationBeanList);
                    return "index";
                case 1:  //1==11
                case 11:  //leader
                    try {
                        userInfoBean =userInfoService.getUserInfo(leaderUid);
                        publicationBeanList = publicationService.getPublicationListByUid(leaderUid);
                        educationBeanList = educationService.getEducationList(leaderUid);
                        experienceBeanList = experienceService.getExperienceBeanList(leaderUid);
                        awardBeanList = awardService.getAwardBeanList(leaderUid);
                        interestBeanList = interestService.getInterestBeanList(leaderUid);
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
                    return "leader";
                case 12:  // member
                    try {
                        userInfoBeanList =userInfoService.getUserInfoBeanList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("userInfoBeanList", userInfoBeanList);
                    return "member";
                case 13:  //picture
                    try {
                        pictureBeanList =pictureService.getAlbumList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("pictureBeanList", pictureBeanList);
                    return "picture";
                case 2:  //research
                    model.addAttribute("language",language);
                    return "research";
                case 3:  //publication
                    try {
                        publicationBeanList = publicationService.getPublicationList();
                        session.setAttribute("publicationBeanList",publicationBeanList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    pageNumber = (int)Math.ceil(publicationBeanList.size()/20.0);
                    pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("publicationBeanList", publicationBeanList.subList(0,Math.min(20,publicationBeanList.size())));
                    model.addAttribute("page", 1);
                    model.addAttribute("pageList",pageList);
                    model.addAttribute("year",0);
                    return "publication";
                case 4:  //opening
                    model.addAttribute("language",language);
                    return "opening";
                case 5:  //news
                    try {
                        newsBeanList = newsService.getNewsList();
                        session.setAttribute("newsBeanList",newsBeanList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    pageNumber = (int)Math.ceil(newsBeanList.size()/7.0);
                    pageList = new int[pageNumber];
                    for(int i =0;i<pageNumber;i++){
                        pageList[i] = i+1;
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("newsBeanList", newsBeanList.subList(0,Math.min(7,newsBeanList.size())));
                    model.addAttribute("page", 1);
                    model.addAttribute("pageList",pageList);
                    model.addAttribute("year",0);
                    return "news";
                case 6:  //contact
                    model.addAttribute("language",language);
                    return "contact";
                case 7:
                    session.removeAttribute("language");
                    session.setAttribute("language",false);
                    try {
                        newsBeanList = newsService.getRecentNews();
                        publicationBeanList = publicationService.getRecentPublicationList();
                        bannerBeanList = bannerService.getRecentBannerBeanList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("language",false);
                    model.addAttribute("bannerBeanList",bannerBeanList);
                    model.addAttribute("newsBeanList", newsBeanList);
                    model.addAttribute("publicationBeanList",publicationBeanList);
                    return "index";
                case 8:
                    session.removeAttribute("language");
                    session.setAttribute("language",true);
                    try {
                        newsBeanList = newsService.getRecentNews();
                        publicationBeanList = publicationService.getRecentPublicationList();
                        bannerBeanList = bannerService.getRecentBannerBeanList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("language",true);
                    model.addAttribute("bannerBeanList",bannerBeanList);
                    model.addAttribute("newsBeanList", newsBeanList);
                    model.addAttribute("publicationBeanList",publicationBeanList);
                    return "index";

                default:
                    try {
                        newsBeanList = newsService.getRecentNews();
                        publicationBeanList = publicationService.getRecentPublicationList();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("language",language);
                    model.addAttribute("newsBeanList", newsBeanList);
                    model.addAttribute("publicationBeanList",publicationBeanList);
                    return "index";
            }
    }


    @PostMapping("/index")
    public void search (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
        System.out.println(id);
    }


}