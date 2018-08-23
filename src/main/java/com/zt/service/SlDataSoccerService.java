package com.zt.service;
import com.zt.dao.SlDataSoccerMapper;
import com.zt.pojo.SlDataSoccer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SlDataSoccerService")
public class SlDataSoccerService {
    @Resource
    private SlDataSoccerMapper slDataSoccerMapper;

    //根据id查询
    public List findByDate(String date){
        List<SlDataSoccer> dataSoccer= this.slDataSoccerMapper.findByDate(date);
        if(dataSoccer!=null){
            return dataSoccer;
        }
        return null;
    }

    //根据期号查询，模糊
    public List findByNmber(String numberOfPeriods){
        List<SlDataSoccer> dataSoccer= this.slDataSoccerMapper.findByNmber(numberOfPeriods);
        if(dataSoccer!=null){
                return dataSoccer;
        }
        return null;
    }

    /**
     * CFR,
     * 从输入日期 fromDate 起，查询连续 periodCount 期的受注场次数据
     * */
    public List getBetGamesFromDate(String fromDate, int periodCount)
    {
        List<SlDataSoccer> dataSoccer= this.slDataSoccerMapper.getBetGamesFromDate(fromDate, periodCount);
        if(dataSoccer!=null){
            return dataSoccer;
        }
        return null;
    }
}
