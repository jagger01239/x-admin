package com.xadmin.sys.mapper;


import com.xadmin.sys.entity.Dataecharts1Entity;
import com.xadmin.sys.entity.Dataecharts3Entity;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;
import java.util.List;

@Mapper
@Resource
public interface BigEchartsMapper {

    Dataecharts1Entity getechart1Data();

    List<Dataecharts3Entity> getechart3Data();
}
