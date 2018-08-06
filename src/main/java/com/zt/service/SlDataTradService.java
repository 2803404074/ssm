package com.zt.service;

import com.zt.dao.SlDataTradMapper;
import com.zt.pojo.SlDataTradWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SlDataTradService")
public class SlDataTradService {
    @Resource
    private SlDataTradMapper tradMapper;

    public int insert(SlDataTradWithBLOBs withBLOBs) {
        int ret = this.tradMapper.insert(withBLOBs);
        if (ret > 0) {
            return ret;
        }
        return 0;
    }

    public List findByDate(String number){
        List<SlDataTradWithBLOBs> ret= this.tradMapper.findByDate(number);
        if(ret!=null){
            return ret;
        }
        return null;
    }
}