package com.zt.controller;

import com.zt.pojo.SlDataBasketballWithBLOBs;
import com.zt.service.SlDataBasketballService;
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

/**
 * 篮球胜分差
 */
@Controller
public class BBsfc {
    private List<Object> lists;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    @Resource
    SlDataBasketballService service;


    @RequestMapping("/getbasketball/sfc/odds")
    @ResponseBody
    public JSONObject getInfo(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            String bbid = request.getParameter("bbid");
            jsonObject = new JSONObject();
            jsonArray = new JSONArray();
            lists = new ArrayList<Object>();
            List<SlDataBasketballWithBLOBs> list = service.findById(bbid);
            for (SlDataBasketballWithBLOBs basketball : list) {
                if (basketball != null) {
                    String contents = basketball.getContents();
                    jsonInfo(contents);
                }
            }
            jsonObject.put("bb_sfc_odds",jsonArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void jsonInfo(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);//第二层
        Iterator iterator = jsonObject.keys();
        Map<String, String> map = new HashMap<>();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);
            if ("id".equals(key)) {
                map.put("matchID", value);
            }
            if ("current_sfc".equals(key)) {
                map = getJson(value, map);
            }
        }
        lists.clear();
        lists.add(map);
        for (int i = 0; i < lists.size(); i++) {
            jsonArray.add(lists.get(i));
        }
    }

    //key值转义
    private Map getJson(String json, Map map) {
        JSONObject jsonObject2 = JSONObject.fromObject(json);//第三层
        Iterator iterator2 = jsonObject2.keys();
        while (iterator2.hasNext()) {
            String key2 = (String) iterator2.next();
            String value2 = jsonObject2.getString(key2);
            System.out.println("解析指定json数据:key=" + key2 + ",value=" + value2);
            JsonTransformation jf = new JsonTransformation();
            String keyName = jf.bbSfcKeyName(key2);//将key值转义
            map.put(keyName, value2);
        }
        System.out.println("转换后：" + map.toString());
        return map;
    }
}
