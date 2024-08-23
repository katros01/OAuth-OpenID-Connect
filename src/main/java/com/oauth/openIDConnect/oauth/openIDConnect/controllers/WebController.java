package com.oauth.openIDConnect.oauth.openIDConnect.controllers;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class WebController {

    @GetMapping
    public String viewHomePage(@AuthenticationPrincipal OAuth2User principal, Model model) {
        if (principal != null) {

            String usernameGit = principal.getAttribute("login");
            String usernameGoogle = principal.getAttribute("given_name");

            if(usernameGit != null){
                model.addAttribute("username", usernameGit);
            }else {
                model.addAttribute("username", usernameGoogle);
            }
        }
        return "userHome";
    }
}
