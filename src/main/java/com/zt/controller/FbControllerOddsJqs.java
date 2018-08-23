/**
 * 创建者：CFR，2018-08-22
 * 维护者：CFR，2018-08-22
 *
 * FbControllerOddsJqs，竞彩足球“进球数”玩法相关 Controller 类
 * 本类响应，“进球数”赔率请求
 *          “受注场次” + “进球数”赔率请求
 *
 *
 * */
package com.zt.controller;

import com.zt.model.*;
import com.zt.service.SlDataSoccerService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FbControllerOddsJqs extends BaseContollerCheckParams{

    @Resource
    SlDataSoccerService dataSoccerService;


    @RequestMapping("/football/get/plain/oddsJqsFromDate")
    @ResponseBody
    public void getOddsJqsFromdate(HttpServletRequest request, HttpServletResponse response)
    {

        response.setContentType("text/html;charset=utf-8");
        try {
            request.setCharacterEncoding("utf-8");
        }

        catch (Exception e){
            e.printStackTrace();
        }

        DateAndCout dc = new DateAndCout("", 1);

        // region 分析输入参数

        checkParamsDateAndCount(request.getParameterMap(), dc);

        // endregion 分析输入参数


        try {
            // region 获取数据

            List<BoFootballBetPeriodOdds> listOddsJqc = listOddsOnly();

            JSONArray jsonListOddsJqc = JSONArray.fromObject(listOddsJqc);

            // endregion


            // 返回
            sendHttpRespone(response, jsonListOddsJqc);
        }
        catch (Exception e){
            e.printStackTrace();
        }




    }


    @RequestMapping("/football/get/plain/betGamesAndOddsJqsFromDate")
    @ResponseBody
    public void getGamesAndOddsJqsFromDate(HttpServletRequest request, HttpServletResponse response)
    {
        response.setContentType("text/html;charset=utf-8");
        try {
            request.setCharacterEncoding("utf-8");
        }

        catch (Exception e){
            e.printStackTrace();
        }

        DateAndCout dc = new DateAndCout("", 1);

        // region 分析输入参数

        checkParamsDateAndCount(request.getParameterMap(), dc);

        // endregion 分析输入参数


        try {
            // region 获取数据

            List<BoFootballBetPeriodOdds> listGameAndOdds = listGameAndOdds();

            JSONArray jsonListOddsJqc = JSONArray.fromObject(listGameAndOdds);

            // endregion


            // 返回
            sendHttpRespone(response, jsonListOddsJqc);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    // 分期返回“进球数”赔率数据
    // 仅包含“进球数”赔率数据，“受注场次”与其它赔率数据为 null
    private List<BoFootballBetPeriodOdds> listOddsOnly()
    {
        // 以下返回 demo 数据，真实数据需要在数据库中查询

        List<BoFootballBetPeriodOdds> listOdds = new ArrayList<BoFootballBetPeriodOdds>();


        // 仅包含“进球数”赔率数据，“受注场次”与其它赔率数据为 null
        // 第一期，3 场比赛
        List<BoFootballBetGameOdds> listOdds1 = new ArrayList<BoFootballBetGameOdds>();

        listOdds1.add(new BoFootballBetGameOdds(null, null,
                new BoFootballOddsJqs("201808105001","9.5","4.15","3.3","3.5","5.6","9.5","17","27"),
                null, null));
        listOdds1.add(new BoFootballBetGameOdds(null, null,
                new BoFootballOddsJqs("201808105002","5.5","2.15","6.3","8.5","9.6","11.5","15","25"),
                null, null));
        listOdds1.add(new BoFootballBetGameOdds(null, null,
                new BoFootballOddsJqs("201808105003","2.5","5.15","5.3","3.25","8.26","8.95","15.6","23.2"),
                null, null));

        // 第二期，1 场比赛
        List<BoFootballBetGameOdds> listOdds2 = new ArrayList<BoFootballBetGameOdds>();

        listOdds2.add(new BoFootballBetGameOdds(null, null,
                new BoFootballOddsJqs("201808116001","3.5","5.1","4.36","7.25","9.6","10.5","14","29"),
                null, null));


        // 第三期，2 场比赛
        List<BoFootballBetGameOdds> listOdds3 = new ArrayList<BoFootballBetGameOdds>();

        listOdds3.add(new BoFootballBetGameOdds(null, null,
                new BoFootballOddsJqs("201808127001","5.1","6.2","7.36","8.45","9.56","10.65","11","20"),
                null, null));

        listOdds3.add(new BoFootballBetGameOdds(null, null,
                new BoFootballOddsJqs("201808127002","3.9","5.82","7.76","9.65","11.56","13.45","15.3","21.2"),
                null, null));


        //
        listOdds.add(new BoFootballBetPeriodOdds("20180810", listOdds1));
        listOdds.add(new BoFootballBetPeriodOdds("20180811", listOdds2));
        listOdds.add(new BoFootballBetPeriodOdds("20180812", listOdds3));

        return listOdds;
    }


    // 分期返回“受注场次” + “进球数”赔率数据
    private List<BoFootballBetPeriodOdds> listGameAndOdds()
    {
        // 以下返回 demo 数据，真实数据需要在数据库中查询
        List<BoFootballBetPeriodOdds> listOdds = new ArrayList<BoFootballBetPeriodOdds>();


        // 仅包含“受注场次” + “进球数”赔率数据，与其它赔率数据为 null
        // 第一期，3 场比赛
        List<BoFootballBetGameOdds> listOdds1 = new ArrayList<BoFootballBetGameOdds>();


        listOdds1.add(new BoFootballBetGameOdds(
                new BoFootballBetGame("201808105001", "周五001", "日职", "2018-08-10 ", "18:00:00", "大  阪", "东京FC", "017001"),
                null,
                new BoFootballOddsJqs("201808105001","9.5","4.15","3.3","3.5","5.6","9.5","17","27"),
                null, null));
        listOdds1.add(new BoFootballBetGameOdds(
                new BoFootballBetGame("201808105002", "周五002", "俄超", "2018-08-10 ", "22:30:00", "乌拉尔", "莫迪纳", "87A6E0"),
                null,
                new BoFootballOddsJqs("201808105002","5.5","2.15","6.3","8.5","9.6","11.5","15","25"),
                null, null));
        listOdds1.add(new BoFootballBetGameOdds(
                new BoFootballBetGame("201808105003", "周五003", "德乙", "2018-08-11 ", "00:30:00", "因戈尔", "菲尔特", "DB31EE"),
                null,
                new BoFootballOddsJqs("201808105003","2.5","5.15","5.3","3.25","8.26","8.95","15.6","23.2"),
                null, null));

        // 第二期，1 场比赛
        List<BoFootballBetGameOdds> listOdds2 = new ArrayList<BoFootballBetGameOdds>();

        listOdds2.add(new BoFootballBetGameOdds(
                new BoFootballBetGame("201808116001", "周六001", "日职", "2018-08-11  ", "12:00:00", "札  幌", "樱  花", "017001"),
                null,
                new BoFootballOddsJqs("201808116001","3.5","5.1","4.36","7.25","9.6","10.5","14","29"),
                null, null));


        // 第三期，2 场比赛
        List<BoFootballBetGameOdds> listOdds3 = new ArrayList<BoFootballBetGameOdds>();

        listOdds3.add(new BoFootballBetGameOdds(
                new BoFootballBetGame("201808127001", "周日001", "日职乙", "2018-08-12  ", "18:00:00", "町  田", "千  叶", "5A9400"),
                null,
                new BoFootballOddsJqs("201808127001","5.1","6.2","7.36","8.45","9.56","10.65","11","20"),
                null, null));

        listOdds3.add(new BoFootballBetGameOdds(
                new BoFootballBetGame("201808127002", "周日002", "日职乙", "2018-08-12  ", "18:00:00", "山  口", "德  岛", "5A9400"),
                null,
                new BoFootballOddsJqs("201808127002","3.9","5.82","7.76","9.65","11.56","13.45","15.3","21.2"),
                null, null));


        //
        listOdds.add(new BoFootballBetPeriodOdds("20180810", listOdds1));
        listOdds.add(new BoFootballBetPeriodOdds("20180811", listOdds2));
        listOdds.add(new BoFootballBetPeriodOdds("20180812", listOdds3));

        return listOdds;

    }


}
