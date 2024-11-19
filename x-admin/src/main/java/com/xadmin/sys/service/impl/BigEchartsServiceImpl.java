package com.xadmin.sys.service.impl;

import com.xadmin.sys.entity.Dataecharts1Entity;
import com.xadmin.sys.entity.Dataecharts3Entity;
import com.xadmin.sys.mapper.BigEchartsMapper;
import com.xadmin.sys.service.BigEchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigEchartsServiceImpl implements BigEchartsService {
    @Autowired
    private BigEchartsMapper bigEchartsMapper;


    @Override
    public Dataecharts1Entity getechart1Data() {
        return bigEchartsMapper.getechart1Data();
    }

    @Override
    public List<Dataecharts3Entity> getechart3Data() {
        return bigEchartsMapper.getechart3Data();
    }
}
