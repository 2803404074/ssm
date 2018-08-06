package com.zt.controller;

import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestControl {
    @RequestMapping("/test")
    @ResponseBody
    public String getInfo(HttpServletRequest request, HttpServletResponse response) {
        return "进来了";
    }
}
