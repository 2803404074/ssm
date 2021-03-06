package com.zt.dao;


import com.zt.pojo.SlDataSoccer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SlDataSoccerMapper {
    //根据id查询
    List<SlDataSoccer> findByDate(String date);

    List<SlDataSoccer> findByNmber(String numberOfPeriods);
    List<SlDataSoccer> getBetGamesFromDate(@Param("fromDate")String fromDate, @Param("periodCount")int periodCount);
}
