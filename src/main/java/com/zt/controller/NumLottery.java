package com.zt.controller;

import com.zt.dao.SlResultNumMapper;
import com.zt.pojo.SlResultNumWithBLOBs;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大乐透数据访问接口
 * 代号:
     * 大乐透 num52
     * 七星彩 num7
     * 排列3  num3
     * 排列5  num5
     * 11选5   num115
 */
@Controller
public class NumLottery {
    private List<Object> lists;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    @Resource
    SlResultNumMapper service;

    @RequestMapping("/getnum/info")
    @ResponseBody
    public JSONObject num52Info(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            String nums = request.getParameter("number");
            jsonObject = new JSONObject();
            jsonArray = new JSONArray();
            lists = new ArrayList<Object>();
            List<SlResultNumWithBLOBs> list = service.findNumById(nums);
            for(SlResultNumWithBLOBs num : list){
                System.out.println(num.getNumberOfPeriods()+","+num.getResultNumber());
                Map<String,String> map= new HashMap<>();
                map.put("stage",num.getNumberOfPeriods());
                map.put("number",num.getResultNumber());
                lists.clear();
                lists.add(map);
                for (int i = 0; i < lists.size(); i++) {
                    jsonArray.add(lists.get(i));
                }
            }
            jsonObject.put("num",jsonArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
