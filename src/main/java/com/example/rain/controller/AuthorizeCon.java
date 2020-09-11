package com.example.rain.controller;


import com.example.rain.dto.AccessTokenDTO;
import com.example.rain.provider.GitHubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeCon {

    @Autowired
    private GitHubProvider gitHubProvider;


    @GetMapping("/callback")

    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id("8a72e8845b188a3a8a84");
        accessTokenDTO.setClient_secret("29c0dbf3df3ac37d30b18b3fc7954a094699c684");
        gitHubProvider.getAccessToken(accessTokenDTO);


        return "index";
    }
}
