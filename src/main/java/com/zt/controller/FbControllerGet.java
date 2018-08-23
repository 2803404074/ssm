/**
 * CFR，2018-08-14
 * 竞彩足球 Getxxxx 系列接口
 * */

package com.zt.controller;

import com.zt.model.*;
import com.zt.pojo.SlDataSoccer;
import com.zt.service.SlDataSoccerService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import servicepublic.GlobalParams;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.*;

@Controller
public class FbControllerGet extends BaseContollerCheckParams {

    @Resource
    SlDataSoccerService dataSoccerService;


    @RequestMapping("/football/get/plain/betGamesFromDate")
    @ResponseBody
    // region getBetGamesFromDate
    // getBetGamesFromDate 返回“受注场次”数据
    // 参数列表
    // fromDate: 起始日期，格式为 YYYYMMDD，如：20180726。缺省为当天
    // periodCount：期数，缺省为 3。值为 0 时，返回所有期

    public void getBetGamesFromDate(HttpServletRequest request, HttpServletResponse response) {

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

        try
        {
            // region 获取数据

            // 假设每天受注场数为 100，应由全局参数控制

            List<SlDataSoccer> games = dataSoccerService.getBetGamesFromDate(dc.fromDate, dc.periodCount * GlobalParams.getInstance().fbMaxGamesInOnePeriod);

            // endregion 获取数据

            // region 组织返回数据

            if (games == null) {
                sendHttpRespone(response, null);
                return;

            }

            List<BoFootballBetPeriod> betPeriods = new ArrayList<BoFootballBetPeriod>();

            List<BoFootballBetGame> betGames = new ArrayList<BoFootballBetGame>();
            String sentryPeriod = "";

            int limit = 0;
            for (SlDataSoccer ds : games)
            {
                if (limit >= dc.periodCount)
                    break;

                if (!sentryPeriod.equals(ds.getNumberOfPeriods().substring(0, 8)))
                {
                    // 检测到与当前期不属于同一期的比赛场次，在下面代码处理期号的划分

                    if (sentryPeriod.isEmpty())
                    {
                        // 第一期，尚未有数据，不需要处理
                    }
                    else {
                        // 开始新一期之前，将当前这一期数据加入列表
                        betPeriods.add(new BoFootballBetPeriod(sentryPeriod, betGames));
                        limit++;
                    }

                    // 开始新一期
                    sentryPeriod = ds.getNumberOfPeriods().substring(0, 8);
                    betGames = new ArrayList<BoFootballBetGame>();     // 新一期的比赛场次列表
                }

                // 本场比赛加入当期
                betGames.add(new BoFootballBetGame(ds.getId(),ds.getNumId(), ds.getEventType(), ds.getStartDate()
                        , ds.getStartTime(), ds.getHome(), ds.getVisitor(), ds.getEventBgColor()));


            }

            if (betGames.size()>0 && limit<dc.periodCount)
            {
                // 加入最后一期的数据
                betPeriods.add(new BoFootballBetPeriod(sentryPeriod, betGames));
            }

            JSONArray jsonBetGames = JSONArray.fromObject(betPeriods);


            // endregion


            // 返回
            sendHttpRespone(response, jsonBetGames);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    // endregion



/*
    // region 分析输入参数，


    protected void checkParamsDateAndCount(Map<String, String[]> params, DateAndCout inputDateAndCount)
    {
        Date currentDate = new Date();
        String fromDate1 = String.format("%1$tY%1$tm%1$td", currentDate);   // 起始日期，格式为 YYYYMMDD，如：20180726。缺省为当天
        int periodCount = GlobalParams.getInstance().periodCountReturn;     // 返回的期数，缺省为 3 天

        String strTemp = "";

        if (params.containsKey("fromDate")) {
            inputDateAndCount.fromDate = params.get("fromDate")[0];
        }
        else
        {
            // 缺省为当前日期
            inputDateAndCount.fromDate = fromDate1;
            */
/*
            throw new IllegalArgumentException("输入参数不正确，输入参数至少需包含fromDate\n" +
                    "正确的调用格式类似：/Football/getBetGamesFromDate.do?fromDate=20180726");
            *//*

        }

        if (params.containsKey("periodCount")) {
            strTemp = params.get("periodCount")[0];

            try {
                inputDateAndCount.periodCount = Integer.parseInt(strTemp);
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("输入参数不正确，periodCount 参数需要的是数值型\n" +
                        "正确的调用格式类似：/Football/getBetGamesFromDate.do?fromDate=20180726&periodCount=3");
            }
        }
    }

    // endregion 分析输入参数
*/

/*
    protected void sendHttpRespone(HttpServletResponse response, Object json)
    {
        try {
            System.out.println(json.toString());
            out = response.getWriter();
            out.println(json);
            out.flush();
            out.close();
        }

        // IOException 异常
        catch (IOException e)
        {

            e.printStackTrace();
        }

        // 其它 Exception 异常
        catch (Exception e)
        {
            //
            e.getMessage();
            e.printStackTrace();
        }

    }
    */
}

