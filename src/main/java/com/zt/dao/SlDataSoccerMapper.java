package com.zt.dao;


import com.zt.pojo.SlDataSoccer;

import java.util.List;

public interface SlDataSoccerMapper {
    //根据id查询
    List<SlDataSoccer> findByDate(String date);

    List<SlDataSoccer> findByNmber(String numberOfPeriods);
}
