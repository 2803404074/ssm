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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 获取篮球全部赔率信息
 */
@Controller
public class BBall {
    private List<JSONObject> lists;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    @Resource
    SlDataBasketballService service;


    /**
     * 请求入口
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getbasketball/all/odds")
    @ResponseBody
    public JSONObject getInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            //设置编码
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            //获取参数(前端请求的url里的参数名必须与这里设置的参数名一致,bbid)
            String bbid = request.getParameter("bbid");
            //初始化对象信息
            jsonObject = new JSONObject();
            jsonArray = new JSONArray();
            lists = new ArrayList<JSONObject>();
            //调用服务处模块执行查询语句
            List<SlDataBasketballWithBLOBs> list = service.findById(bbid);
            for (SlDataBasketballWithBLOBs basketball : list) {
                if (basketball != null) {
                    //获取数据库里的"contents"字段，该字段的内容为json字符串，需要解析
                    String contents = basketball.getContents();
                    //解析json字符串
                    jsonInfo(contents);
                }
            }
            jsonObject.put("bb_all_odds", jsonArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    /**
     * 解析json字符串
     * @param str
     */
    private void jsonInfo(String str) {
        //将json字符串转json对象
        JSONObject jsonObject = JSONObject.fromObject(str);
        //每条数据存为jsonobject，之后每个jsonobject都放入list
        JSONObject jsonName = new JSONObject();

        //迭代器，迭代jsonObject的key
        Iterator iterator = jsonObject.keys();
        while (iterator.hasNext()) {//如果该jsonObject下一条存在key，则遍历
            String key = (String) iterator.next();//每个key的名称
            String value = jsonObject.getString(key);//每个value的名称
            if ("id".equals(key)) {
                jsonName.put("matchID", value);
            }
            //以下字符串均为json字符串，需要再次解析
            if ("current_sfc".equals(key)) {
                jsonName.put("current_sfc",getJson(value, 0));
            }
            if ("current_sf".equals(key)) {
                jsonName.put("current_sf", getJson(value, 1));
            }
            if ("current_rfsf".equals(key)) {
                jsonName.put("current_rfsf", getJson(value, 2));
            }
            if ("current_dxf".equals(key)) {
                jsonName.put("current_dxf", getJson(value, 3));
            }
        }
        lists.clear();
        lists.add(jsonName);
        for (int i = 0; i < lists.size(); i++) {
            jsonArray.add(lists.get(i));
        }
    }

    //内嵌json解析以及key值的转义
    private JSONObject getJson(String json, int index) {
        JSONObject jsonName = new JSONObject();
        JSONObject jsonObject2 = JSONObject.fromObject(json);//第三层
        Iterator iterator2 = jsonObject2.keys();
        JsonTransformation jf = new JsonTransformation();
        String keyName = "";
        while (iterator2.hasNext()) {
            String key2 = (String) iterator2.next();
            String value2 = jsonObject2.getString(key2);
            System.out.println("解析指定json数据:key=" + key2 + ",value=" + value2);
            switch (index) {
                case 0: {
                    keyName = jf.bbSfcKeyName(key2);
                    break;
                }
                case 1: {
                    keyName = jf.bbsfKeyName(key2, 0);
                    break;
                }
                case 2: {
                    keyName = jf.bbsfKeyName(key2, 1);
                    break;
                }
                case 3: {
                    keyName = jf.bbdxfKeyName(key2);
                    break;
                }
                default:
                    break;
            }
            jsonName.put(keyName, value2);
        }
        System.out.println("转换后" + jsonName.toString());
        return jsonName;
    }
}
