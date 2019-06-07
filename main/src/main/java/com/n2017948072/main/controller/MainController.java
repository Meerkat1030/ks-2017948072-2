package com.n2017948072.main.controller;

import com.n2017948072.main.service.BasicService;
import com.n2017948072.main.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private BasicService basicService;
    private ProfileService profileService;

    public MainController(BasicService basicService, ProfileService profileService) {
        this.basicService = basicService;
        this.profileService = profileService;
    }

    @GetMapping("/")
    public String list(Model model){
        model.addAttribute("basicList", basicService.findBasicListCollections());
        model.addAttribute("profileList", profileService.findProfileListCollections());
        return "index";
    }
}
