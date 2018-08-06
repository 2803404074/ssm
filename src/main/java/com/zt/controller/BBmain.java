package com.zt.controller;

import com.zt.model.BB_MainInfo;
import com.zt.pojo.SlDataBasketballWithBLOBs;
import com.zt.service.SlDataBasketballService;
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
import java.util.List;

@Controller
public class BBmain {
    private List<Object> lists;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    @Resource
    SlDataBasketballService service;

    @RequestMapping("/getbasketball/main")
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
                    String id = basketball.getId();
                    String numId = basketball.getNumId();//赛事编号
                    String eventType = basketball.getEventType();//赛事
                    String date = basketball.getStartDate();
                    String time = basketball.getStartTime();
                    String home = basketball.getHome();
                    String abrv = basketball.getVisitor();
                    BB_MainInfo bb_mainInfo = new BB_MainInfo(id,numId, eventType, date, time, home, abrv);
                    lists.clear();
                    lists.add(bb_mainInfo);
                    for (int i = 0; i < lists.size(); i++) {
                        jsonArray.add(lists.get(i));
                    }
                }
            }
            jsonObject.put("bb_info", jsonArray);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
