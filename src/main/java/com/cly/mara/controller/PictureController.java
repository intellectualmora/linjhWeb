package com.cly.mara.controller;

import com.cly.mara.bean.PictureBean;
import com.cly.mara.service.PictureService;
import com.cly.mara.service.PictureServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PictureController {
    PictureService pictureService = new PictureServiceImpl();
    List<PictureBean> pictureBeanList = null;
    @GetMapping(value = "/album")
    public String getAlbum(@RequestParam(name="year") int year , Model model){
        try {
           pictureBeanList = pictureService.getPictureBeanList(year);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("pictureBeanList",pictureBeanList);
        model.addAttribute("year",year);
        return "album";
    }
}
