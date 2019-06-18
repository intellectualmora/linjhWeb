package com.cly.mara.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @GetMapping("/index")
    public void getId (@RequestParam(name="id", required=false, defaultValue="0") int id, Model model) {
        System.out.println(id);
    }

}