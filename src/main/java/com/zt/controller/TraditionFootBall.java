package com.zt.controller;
import com.zt.model.T_FB_Main;
import com.zt.pojo.SlDataTradWithBLOBs;
import com.zt.service.SlDataTradService;
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
import java.util.List;

/**
 * 传统足彩获取主要信息接口
 */
@Controller
public class TraditionFootBall {
    private JSONObject jsonObject;
    private List<Object> lists = new ArrayList<Object>();
    private JSONArray jsonArray;
    @Resource
    private
    SlDataTradService service;
    @RequestMapping("/gettrdfootball/main")
    @ResponseBody
    public void getInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            jsonObject = new JSONObject();
            jsonArray = new JSONArray();
            String date = request.getParameter("termnumber");
            List<SlDataTradWithBLOBs> list = service.findByDate(date);
            for (SlDataTradWithBLOBs trad : list) {
                if (trad != null) {
                    String id = trad.getId();//赛事id
                    String numId = trad.getNumId();//场次
                    String eventType = trad.getEventType();//赛事
                    String startDate = trad.getStartDate();//开赛时间（日期）
                    String startTime = trad.getStartTime();//开赛时间（时分）
                    String home = trad.getHome();//主队名称
                    String visitor = trad.getVisitor();//客队名称
                    String eventBgColor = trad.getEventBgColor();//赛事背景颜色
                    T_FB_Main info = new T_FB_Main(id,numId,eventType,startDate,startTime,home,visitor,eventBgColor);
                    lists.clear();
                    lists.add(info);
                    for (int i=0;i<lists.size();i++){
                        jsonArray.add(lists.get(i));
                    }
                } else {
                    System.out.println("查询失败");
                }
            }
            jsonObject.put("trdfb_main",jsonArray);
            out.println(jsonObject);
            out.flush();
            out.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
