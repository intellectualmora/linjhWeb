package com.cly.mara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
    @GetMapping(value = "/index")
    public String getId (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
            switch (id){
                case 0:
                    return "index";
                case 1:
                    return "group";
                case 11:
                    return "leader";
                case 12:
                    return "member";
                case 13:
                    return "picture";
                case 14:
                    return "alumni";
                case 2:
                    return "research";
                case 3:
                    return "publication";
                case 4:
                    return "resources";
                case 5:
                    return "news";
                case 6:
                    return "contact";
                case 7:
                    return "login";
                default:
                    return "index";
            }
    }

    @PostMapping("/index")
    public void search (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
        System.out.println(id);
    }

}