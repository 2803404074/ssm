package com.zt.controller;
import com.zt.model.FB_MainInfo;
import com.zt.pojo.SlDataSoccer;
import com.zt.service.SlDataSoccerService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 获取可购买的主要信息(三天,今天之后的三天，包括今天或不包括今天)
 */
@Controller
public class FbMainController {
    private JSONObject jsonObject;
    private Map<String, Object> maps;
    private List<Object> lists, lists2, lists3;
    @Resource
    private
    SlDataSoccerService dataSoccerService;

    @RequestMapping("/getfootball/main")
    @ResponseBody
    public JSONObject getInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            init();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String date = df.format(new Date());
            System.out.println("时间:"+date);
            List<SlDataSoccer> list = dataSoccerService.findByDate("2018-08-07");


            String period1 = "";
            String period2 = "";
            period1 = (list.get(0).getNumberOfPeriods()).substring(0,8);
            for (SlDataSoccer slDataSoccer : list) {
                if (slDataSoccer != null) {
                    String id = slDataSoccer.getId();
                    String numId = slDataSoccer.getNumId();//赛事编号
                    String eventType = slDataSoccer.getEventType();//赛事
                    String startDate = slDataSoccer.getStartDate();//开赛时间（日期）
                    String startTime = slDataSoccer.getStartTime();//开赛时间（时分）
                    String home = slDataSoccer.getHome();//主队名称
                    String visitor = slDataSoccer.getVisitor();//客队名称
                    String eventBgColor = slDataSoccer.getEventBgColor();//赛事背景颜色
                    FB_MainInfo FB_MainInfo = new FB_MainInfo(id, numId, eventType, startDate, startTime, home, visitor, eventBgColor);
                    //方法二
                    String  number = slDataSoccer.getNumberOfPeriods().substring(0,8);
                    if(period1.equals(number)){
                        lists.add(FB_MainInfo);
                        period1 = number;
                    }else if (period2==""){
                        period2=number;
                    }
                    if(period2.equals(number) && period2!=""){
                        lists2.add(FB_MainInfo);
                        period2 = number;
                    }else if (!period1.equals(number)){
                        lists3.add(FB_MainInfo);
                    }
                } else {
                    System.out.println("错误");
                }
            }
            maps.put("one", lists);
            maps.put("tow", lists2);
            maps.put("three",lists3);
            jsonObject.put("mainInfo", maps);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void init() {
        jsonObject = new JSONObject();
        maps = new HashMap<>();
        lists = new ArrayList<>();
        lists2 = new ArrayList<>();
        lists3 = new ArrayList<>();
    }

}
