package com.zt.controller;

import com.zt.model.FB_SpfInfo;
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
 * 获取胜平负赔率信息
 */
@Controller
public class FbSpfController {
    private JSONObject jsonObject;
    private List<Object> lists;
    private JSONArray array;
    private PrintWriter out;
    @Resource
    SlDataSoccerService dataSoccerService;

    @RequestMapping("/getfootball/spf/odds")
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
            System.out.println("json信息"+array.toString());
            jsonObject.put("spf_odds",array);
            out.println(jsonObject);
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //解析
    private void jsonInfo(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);//第二层
        Iterator iterator = jsonObject.keys();
        FB_SpfInfo FBSpfInfo = new FB_SpfInfo();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);

            //获取让球属性,塞进map
            if ("handicap".equals(key)) {
                FBSpfInfo.setHandicap(value);
            }
            //id
            if("id".equals(key)){
                FBSpfInfo.setMatchID(value);
            }
            //获取让球和不让求的赔率
            if (key.equals("current_spf")) {
                JSONObject changName = getJson(value,1);
                FBSpfInfo.setCurrent_spf(changName);
                System.out.println("changName:"+changName);
            }
            if (key.equals("current_rqspf")) {
                JSONObject changName = getJson(value,1);
                FBSpfInfo.setCurrent_rqspf(changName);
            }
        }

        lists.clear();
        lists.add(FBSpfInfo);
        System.out.println("对象信息:"+lists);
        for (int i=0;i<lists.size();i++){
            array.add(lists.get(i));
        }
    }
    //key值转义
    private JSONObject getJson(String json, int index) {
        JSONObject jsonObjectss = new JSONObject();
        JSONObject jsonObject2 = JSONObject.fromObject(json);//第三层
        Iterator iterator2 = jsonObject2.keys();
        while (iterator2.hasNext()) {
            String key2 = (String) iterator2.next();
            String value2 = jsonObject2.getString(key2);
            if (index == 0) {
                System.out.println("还有json:key=" + key2 + ",value=" + value2);
            } else {
                System.out.println("解析指定json数据:key=" + key2 + ",value=" + value2);
                JsonTransformation jf = new JsonTransformation();
                String keyName = jf.changeKeyName(key2);//将key值转义
                jsonObjectss.put(keyName,value2);
            }
        }
        System.out.println("转换后："+jsonObjectss.toString());
        return jsonObjectss;
    }


    //初始化
    private void init(HttpServletResponse response){
        try {
            out = response.getWriter();
            jsonObject = new JSONObject();
            array = new JSONArray();
            lists = new ArrayList<Object>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
