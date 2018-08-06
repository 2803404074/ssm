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
            String[] dd = date.split("-");
            int sys = Integer.parseInt(dd[2]);
            List<SlDataSoccer> list = dataSoccerService.findByDate(date);
            String one = "";
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
                    String bb = slDataSoccer.getNumberOfPeriods().substring(6);
                    String cc = bb.substring(0, 2);
                    lists.add(FB_MainInfo);
//                    if (database != sys) {
//                        lists2.add(FB_MainInfo);
//                    }
//                    if (database != sys) {
//                        lists3.add(FB_MainInfo);
//                    }
                } else {
                    System.out.println("查询失败");
                }
            }
            maps.put(one, lists);
//            maps.put("tow", lists2);
//            maps.put("three", lists3);
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
