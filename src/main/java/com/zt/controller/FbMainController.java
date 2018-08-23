package com.zt.controller;

import com.zt.model.FB_MainInfo;
import com.zt.model.FB_threeall;
import com.zt.pojo.SlDataSoccer;
import com.zt.service.SlDataSoccerService;
import com.zt.utils.JsonTransformation;
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
 * 接口一：
 * 获取可购买的主要信息(三天,今天之后的三天，包括今天或不包括今天)
 *
 * 接口二：
 * 获取可购买的主要信息和赔率信息(三天)
 *
 */
@Controller
public class FbMainController {
    private JSONObject jsonObject;
    private Map<String, Object> maps;
    private List<Object> lists, lists2, lists3;

    private String oid, handicap;
    private Object current_spf, current_rqspf;

    private List<FB_threeall> fbList,fbList2,fbList3;

    @Resource
    private
    SlDataSoccerService dataSoccerService;

    /**
     * 获取三天的受注信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getfootball/main")
    @ResponseBody
    public JSONObject getInfo(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            init();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String date = df.format(new Date());
            System.out.println("时间:" + date);
            List<SlDataSoccer> list = dataSoccerService.findByDate(date);

            String period1 = "";
            String period2 = "";
            period1 = (list.get(0).getNumberOfPeriods()).substring(0, 8);
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
                    String number = slDataSoccer.getNumberOfPeriods().substring(0, 8);
                    if (period1.equals(number)) {
                        lists.add(FB_MainInfo);
                        period1 = number;
                    } else if (period2 == "") {
                        period2 = number;
                    }
                    if (period2.equals(number) && period2 != "") {
                        lists2.add(FB_MainInfo);
                        period2 = number;
                    } else if (!period1.equals(number)) {
                        lists3.add(FB_MainInfo);
                    }
                } else {
                    System.out.println("错误");
                }
            }
            maps.put("one", lists);
            maps.put("tow", lists2);
            maps.put("three", lists3);
            jsonObject.put("mainInfo", maps);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 初始化变量
     */
    private void init() {
        jsonObject = new JSONObject();
        maps = new HashMap<>();
        lists = new ArrayList<>();
        lists2 = new ArrayList<>();
        lists3 = new ArrayList<>();
        fbList = new ArrayList<FB_threeall>();
        fbList2 = new ArrayList<FB_threeall>();
        fbList3= new ArrayList<FB_threeall>();
    }

    /**
     * 获取三天的所有信息
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getfootball/mainandodds")
    @ResponseBody
    public JSONObject getThreeMd(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            init();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
            String date = df.format(new Date());
            System.out.println("时间:" + date);
            List<SlDataSoccer> list = dataSoccerService.findByDate(date);

            String period1 = "";
            String period2 = "";
            period1 = (list.get(0).getNumberOfPeriods()).substring(0, 8);
            for (SlDataSoccer slDataSoccer : list) {
                    String id = slDataSoccer.getId();
                    String numId = slDataSoccer.getNumId();//赛事编号
                    String eventType = slDataSoccer.getEventType();//赛事
                    String startDate = slDataSoccer.getStartDate();//开赛时间（日期）
                    String startTime = slDataSoccer.getStartTime();//开赛时间（时分）
                    String home = slDataSoccer.getHome();//主队名称
                    String visitor = slDataSoccer.getVisitor();//客队名称
                    String eventBgColor = slDataSoccer.getEventBgColor();//赛事背景颜色
                    String contens = slDataSoccer.getContents();//赔率

                    resolveJSON(contens);
                    FB_threeall fb_threeall = new FB_threeall(id,numId,eventType,startDate,startTime,home,visitor,eventBgColor,oid,handicap,current_spf,current_rqspf);
                    //区别往后比赛天数
                    String number = slDataSoccer.getNumberOfPeriods().substring(0, 8);
                    if (period1.equals(number)) {
                        period1 = number;
                        fbList.add(fb_threeall);
                        setMaps(1,fbList);
                    } else if (period2 == "") {
                        period2 = number;
                    }

                    if (period2.equals(number) && period2 != "") {
                        period2 = number;
                        fbList2.add(fb_threeall);
                        setMaps(2,fbList2);

                    } else if (!period1.equals(number)) {
                        fbList3.add(fb_threeall);
                        setMaps(3,fbList3);
                    }
            }
            jsonObject.put("ThirdDaysAll", maps);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    /**
     * 包装
     * @param index
     * @param list
     */
    private void setMaps(int index,List<FB_threeall> list){
        switch (index){
            case 1:{maps.put("FirstDdays", list);break;}
            case 2:{maps.put("SecondDays", list);break;}
            case 3:{maps.put("ThirdDays", list);break;}
        }
    }


    //解析
    private void resolveJSON(String str) {
        JSONObject jsonObject = JSONObject.fromObject(str);//第二层
        Iterator iterator = jsonObject.keys();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);

            //获取让球属性,塞进map
            if ("handicap".equals(key)) {
                handicap = value;
            }
            //id
            if ("id".equals(key)) {
                oid = value;
            }
            //获取让球和不让求的赔率
            if (key.equals("current_spf")) {
                JSONObject changName = getJson(value);
                current_spf = changName;
            }
            if (key.equals("current_rqspf")) {
                JSONObject changName = getJson(value);
                current_rqspf = changName;
            }
        }
    }

    //key值转义
    private JSONObject getJson(String json) {
        JSONObject jsonObjectss = new JSONObject();
        JSONObject jsonObject2 = JSONObject.fromObject(json);//第三层
        Iterator iterator2 = jsonObject2.keys();
        while (iterator2.hasNext()) {
            String key2 = (String) iterator2.next();
            String value2 = jsonObject2.getString(key2);
            System.out.println("还有json:key=" + key2 + ",value=" + value2);
            System.out.println("解析指定json数据:key=" + key2 + ",value=" + value2);
            JsonTransformation jf = new JsonTransformation();
            String keyName = jf.changeKeyName(key2);//将key值转义
            jsonObjectss.put(keyName, value2);

        }
        System.out.println("转换后：" + jsonObjectss.toString());
        return jsonObjectss;
    }

}
