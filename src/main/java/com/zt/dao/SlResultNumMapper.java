package com.zt.dao;


import com.zt.pojo.SlResultNumWithBLOBs;

import java.util.List;

public interface SlResultNumMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sl_result_num
     *
     * @mbggenerated
     */
    int insert(SlResultNumWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Sl_result_num
     *
     * @mbggenerated
     */
    int insertSelective(SlResultNumWithBLOBs record);

    List<SlResultNumWithBLOBs> findNumById(String id);
}