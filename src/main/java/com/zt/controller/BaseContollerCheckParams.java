/**
 * CFR，2018-08-21
 * 带有 HttpServletRequest 输入参数检查功能的 Controller 基类
 * */

package com.zt.controller;


import org.springframework.stereotype.Controller;
import servicepublic.GlobalParams;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

@Controller
public class BaseContollerCheckParams {
    protected PrintWriter out;

    /**
     * CFR,2018-08-21
     * 方法名：checkParamsDateAndCount
     * 描述： 检查 HttpServletRequest 输入参数中是否有完整的日期、连续期数
     *       fromDate，起始日期，缺省为当天
     *       periodCount，返回期数，缺省为 3 期
     *       如有输入，则在 dc 中返回输入的参数值
     *       如未有输入，则在 dc 中返回缺省值
     *
     * */
    // region 检查 HttpServletRequest 输入参数
    protected static void checkParamsDateAndCount(Map<String, String[]> params, DateAndCout dc)
    {
        Date currentDate = new Date();
        String fromDate1 = String.format("%1$tY%1$tm%1$td", currentDate);   // 起始日期，格式为 YYYYMMDD，如：20180726。缺省为当天

        String strTemp = "";

        if (params.containsKey("fromDate")) {
            dc.fromDate = params.get("fromDate")[0];
        }
        else
        {
            // 缺省为当前日期
            dc.fromDate = fromDate1;
            /*
            throw new IllegalArgumentException("输入参数不正确，输入参数至少需包含fromDate\n" +
                    "正确的调用格式类似：/Football/getBetGamesFromDate.do?fromDate=20180726");
            */
        }

        if (params.containsKey("periodCount"))
        {
            strTemp = params.get("periodCount")[0];

            try {
                dc.periodCount = Integer.parseInt(strTemp);
            }
            catch (Exception e)
            {
                throw new IllegalArgumentException("输入参数不正确，periodCount 参数需要的是数值型\n" +
                        "正确的调用格式类似：/Football/getBetGamesFromDate.do?fromDate=20180726&periodCount=3");
            }

        }
        else
        {
            dc.periodCount = GlobalParams.getInstance().periodCountReturn;
        }

    }


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
}


class DateAndCout
{
    public String fromDate;
    public int periodCount;

    public DateAndCout(String fromDate, int periodCount)
    {
        this.fromDate = fromDate;
        this.periodCount = periodCount;
    }
}



