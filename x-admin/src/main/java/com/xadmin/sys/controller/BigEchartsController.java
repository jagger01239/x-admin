package com.xadmin.sys.controller;


import com.xadmin.sys.entity.Dataecharts1Entity;
import com.xadmin.sys.entity.Dataecharts3Entity;
import com.xadmin.sys.service.BigEchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bigecharts")
public class BigEchartsController {
    @Autowired
    private BigEchartsService bigEchartsService;


    @RequestMapping("/echart1")
    public Dataecharts1Entity echart1(){
        Dataecharts1Entity dataecharts1Entity = bigEchartsService.getechart1Data();
        return dataecharts1Entity;
    }

    @RequestMapping("/echart2")
    public Dataecharts1Entity echart2(){
        Dataecharts1Entity dataecharts1Entity = bigEchartsService.getechart1Data();
        return dataecharts1Entity;
    }

    @RequestMapping("/echart3")
    public Map<String,Object> echart3(){
        List<Dataecharts3Entity> datalist = bigEchartsService.getechart3Data();
        System.out.println(datalist);
        ArrayList<Integer> month = new ArrayList<>();
        ArrayList<Integer> total = new ArrayList<>();
        int i = 0;
        for (i = 0; i < datalist.size(); i++) {
            Dataecharts3Entity day = datalist.get(i);
            month.add(day.getMonth());
            total.add(day.getTotal());
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("month", month);
        map.put("total", total);
        System.out.println(map);
        return map;
    }




}
