package com.zt.controller;
import com.zt.model.*;
import com.zt.pojo.SlDataSoccer;
import com.zt.service.SlDataSoccerService;
import com.zt.utils.JsonTransformation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 获取所有的赔率信息
 */
@Controller
public class FbAllOddsController {
    private JSONObject jsonObject;
    private List<Object> lists;
    private JSONArray array;
    private PrintWriter out;
    @Resource
    SlDataSoccerService dataSoccerService;

    @RequestMapping("/getfootball/all/odds")
    @ResponseBody
    public void getInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            init(response);
            String numberOfPeriods = request.getParameter("numberOfPeriods");
            List<SlDataSoccer> list = dataSoccerService.findByNmber(numberOfPeriods);
            for (SlDataSoccer slDataSoccer : list) {
                if (slDataSoccer != null) {
                    String str = slDataSoccer.getContents();//contents字段为json字符串，需解析
                    jsonInfo(str);//解析
                } else {
                    System.out.println("查询失败");
                }
            }
            jsonObject.put("allOdds",array);
            out.println(jsonObject);
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    //初始化
    private void init(HttpServletResponse response) {
        try {
            jsonObject = new JSONObject();
            out = response.getWriter();
            array = new JSONArray();
            lists = new ArrayList<Object>();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //解析
    private void jsonInfo(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);//第二层
        Iterator iterator = jsonObject.keys();
        FB_all fb_all = new FB_all();
        FB_BfInfo FBBfInfo = new FB_BfInfo();
        FB_BqcInfo FBBqcInfo = new FB_BqcInfo();
        FB_JqsInfo FBJqsInfo = new FB_JqsInfo();
        FB_SpfInfo FBSpfInfo = new FB_SpfInfo();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);
            //id
            if("id".equals(key)){
//                FBSpfInfo.setMatchID(value);
//                FBBfInfo.setMatchID(value);
//                FBBqcInfo.setMatchID(value);
//                FBJqsInfo.setMatchID(value);
                fb_all.setId(value);
            }
            //不让球赔率
            if (key.equals("current_spf")) {
                JSONObject changName = getJson(value,0);
                FBSpfInfo.setCurrent_spf(changName);
                fb_all.setFBSpfInfo(FBSpfInfo);
            }
            //让球赔率
            if (key.equals("current_rqspf")) {
                JSONObject changName = getJson(value,0);
                FBSpfInfo.setCurrent_rqspf(changName);
                fb_all.setFBSpfInfo(FBSpfInfo);
            }
            if("handicap".equals(key)){
                FBSpfInfo.setHandicap(value);
                fb_all.setFBSpfInfo(FBSpfInfo);
            }

            //总进球数赔率
            if (key.equals("current_jqs")) {
                JSONObject changName = getJson(value,2);
                FBJqsInfo.setCurrent_jqs(changName);
                fb_all.setFBJqsInfo(FBJqsInfo);
            }
            //半全场赔率
            if (key.equals("current_bqc")) {
                JSONObject changName = getJson(value,3);
                FBBqcInfo.setCurrent_bqc(changName);
                fb_all.setFBBqcInfo(FBBqcInfo);
            }
            //比分赔率
            if (key.equals("current_bf")) {
                JSONObject changName = getJson(value,4);
                FBBfInfo.setCurrent_bf(changName);
                fb_all.setFBBfInfo(FBBfInfo);
            }
        }
        lists.clear();
        lists.add(fb_all);
        for (int i=0;i<lists.size();i++){
            array.add(lists.get(i));
        }
    }

    //转义
    private JSONObject getJson(String json, int index) {
        JSONObject jsonObjectss = new JSONObject();
        JSONObject jsonObject2 = JSONObject.fromObject(json);//第三层
        Iterator iterator2 = jsonObject2.keys();
        while (iterator2.hasNext()) {
            String key2 = (String) iterator2.next();
            String value2 = jsonObject2.getString(key2);
            switch (index){
                case 0 : {
                    JsonTransformation jf = new JsonTransformation();
                    String keyName = jf.changeKeyName(key2);//将key值转义
                    jsonObjectss.put(keyName,value2);
                    break;}
                case 2 : {
                    JsonTransformation jf = new JsonTransformation();
                    String keyName = jf.jqsKeyName(key2);//将key值转义
                    jsonObjectss.put(keyName,value2);
                    break;}
                case 3 : {
                    JsonTransformation jf = new JsonTransformation();
                    String keyName = jf.fqcKeyName(key2);//将key值转义
                    jsonObjectss.put(keyName,value2);break;}
                case 4 : {
                    JsonTransformation jf = new JsonTransformation();
                    String keyName = jf.bfKeyName(key2);//将key值转义
                    jsonObjectss.put(keyName,value2);
                    break;
                }
                    default: break;
            }
        }
        System.out.println("转换后："+jsonObjectss.toString());
        return jsonObjectss;
    }
}
