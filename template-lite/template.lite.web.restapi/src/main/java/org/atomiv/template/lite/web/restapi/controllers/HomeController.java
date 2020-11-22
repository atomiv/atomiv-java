package org.atomiv.template.lite.web.restapi.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

//    @Value("${app.version}")
//    private String appVersion;
//
//    @GetMapping
//    @RequestMapping("/")
//    public Map getStatus() {
//        Map map = new HashMap<String, String>();
//        map.put("app-version", appVersion);
//        return map;
//    }


    /**
     * Return the start page
     * @return
     */
    @GetMapping("/")
    public String index() {
        // return "index page";

        // -> org.atomiv.template.lite.web.restapi.controllers.HomeController@410ae5ac
        return super.toString();
//        System.out.println(customer);
//        System.out.println("hello");
    }


}
