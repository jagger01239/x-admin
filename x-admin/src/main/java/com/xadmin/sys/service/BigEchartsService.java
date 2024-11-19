package com.xadmin.sys.service;

import com.xadmin.sys.entity.Dataecharts1Entity;
import com.xadmin.sys.entity.Dataecharts3Entity;

import java.util.List;

public interface BigEchartsService {
    Dataecharts1Entity getechart1Data();

    List<Dataecharts3Entity> getechart3Data();
}
