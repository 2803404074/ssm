package com.zt.controller;

import com.zt.pojo.SlDataTradWithBLOBs;
import com.zt.service.SlDataTradService;
import com.zt.utils.JsonTransformation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class TrOdds {
    private JSONObject jsonObject;
    private List<Object> lists = new ArrayList<Object>();
    private JSONArray jsonArray;
    @Resource
    private
    SlDataTradService service;

    @RequestMapping("/gettrdfootball/sf/odds")
    @ResponseBody
    public JSONObject getInfo(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            init();
            String date = request.getParameter("termnumber");
            List<SlDataTradWithBLOBs> list = service.findByDate(date);
            for (SlDataTradWithBLOBs ret : list) {
                if (ret != null) {
                    String str = ret.getContents();//contents字段为json字符串，需解析
                    jsonInfo(str);//解析
                } else {
                    System.out.println("查询失败");
                }
            }
            jsonObject.put("tr_fb_sfodds",jsonArray);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
    //初始化
    private void init(){
            jsonObject = new JSONObject();
            jsonArray = new JSONArray();
            lists = new ArrayList<Object>();
    }
    private void jsonInfo(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);//第二层
        Iterator iterator = jsonObject.keys();
        Map<String, String> map = new HashMap<>();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);
            //id
            if ("id".equals(key)) {
                map.put("matchID", value);
            }
            if ("odds_avg".equals(key)) {
                map =  getJson(value,map);
            }
        }
        lists.clear();
        lists.add(map);
        System.out.println("对象信息:" + lists);
        for (int i = 0; i < lists.size(); i++) {
            jsonArray.add(lists.get(i));
        }
    }

    //key值转义
    private Map getJson(String json,Map map) {
        JSONObject jsonObjectss = new JSONObject();
        JSONObject jsonObject2 = JSONObject.fromObject(json);//第三层
        Iterator iterator2 = jsonObject2.keys();
        while (iterator2.hasNext()) {
            String key2 = (String) iterator2.next();
            String value2 = jsonObject2.getString(key2);
            System.out.println("解析指定json数据:key=" + key2 + ",value=" + value2);
            JsonTransformation jf = new JsonTransformation();
            if(key2.equals("a")||key2.equals("d")||key2.equals("h")){
                String keyName = jf.trSfKeyName(key2);//将key值转义
                map.put(keyName,value2);
            }
        }
        System.out.println("转换后：" + map.toString());
        return map;
    }
}
