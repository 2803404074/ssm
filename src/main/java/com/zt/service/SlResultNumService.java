package com.zt.service;

import com.zt.dao.SlResultNumMapper;
import com.zt.pojo.SlResultNumWithBLOBs;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("SlResultNumService")
public class SlResultNumService {
    @Resource
    private SlResultNumMapper slResultNumMapper;

    public int insert(SlResultNumWithBLOBs withBLOBs) {
        int ret = this.slResultNumMapper.insert(withBLOBs);
        if (ret > 0) {
            return ret;
        }
        return 0;
    }

    public List findNumById(String id){
        List<SlResultNumWithBLOBs> list = slResultNumMapper.findNumById(id);
        if(list!=null){
            return list;
        }
        return null;
    }
}
