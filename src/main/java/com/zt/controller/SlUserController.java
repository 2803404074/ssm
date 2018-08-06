package com.zt.controller;
import com.zt.pojo.SlUser;
import com.zt.service.SlUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户登陆、注册类
 */
@Controller
public class SlUserController {

    private JSONObject jsonObject;
    private List<SlUser> list;
    private JSONArray jsonArray;
    @Resource
    SlUserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public void login(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            String name =  request.getParameter("account");
            String pass =  request.getParameter("password");
            SlUser ret = userService.login(name,pass);
            list = new ArrayList<>();
            jsonObject = new JSONObject();
            jsonArray = new JSONArray();
            if(ret!=null){
                //登陆成功
                jsonObject.put("user",ret);
                response.getWriter().print(jsonObject);
            }else{
                //登陆失败
                jsonObject.put("user",null);
                response.getWriter().print(jsonObject);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//
    @RequestMapping("/regist")
    @ResponseBody
    public JSONObject regist(HttpServletRequest request,
                             HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            jsonObject = new JSONObject();
            String name =  request.getParameter("name");
            String account =  request.getParameter("account");
            String pass =  request.getParameter("password");
            String phone =  request.getParameter("phone");

            SlUser slUser = new SlUser(name,account,pass,phone);
            int ret = userService.insertUser(slUser);
            if(ret>0){
                jsonObject.put("name",slUser.getuName());
                jsonObject.put("account",slUser.getuAccount());
                jsonObject.put("pass",slUser.getuPassword());
                jsonObject.put("phone",slUser.getuPhone());
            }else{
                //注册失败
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
