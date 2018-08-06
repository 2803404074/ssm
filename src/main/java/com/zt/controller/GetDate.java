package com.zt.controller;

import com.zt.pojo.SlDataSoccer;
import com.zt.service.SlDataSoccerService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class GetDate {
    @Resource
    private
    SlDataSoccerService dataSoccerService;
    private Date date;
    private JSONObject jsonObject;
    @RequestMapping("/getdate")
    @ResponseBody
    public JSONObject getInfo(HttpServletRequest request, HttpServletResponse response) {

        jsonObject = new JSONObject();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        String date = df.format(new Date());
        String[] dd = date.split("-");
        String datenumber = request.getParameter("datenumber");
        for (int i = 0; i < 5; i++) {
            System.out.println(date+","+date.toString());
            List<SlDataSoccer> lists = dataSoccerService.findByDate(date.toString());
            if (lists != null) {
                jsonObject.put("date",date);
            }
        }
        return jsonObject;
    }
}
