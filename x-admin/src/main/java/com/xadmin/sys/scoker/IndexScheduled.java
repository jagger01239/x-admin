package com.xadmin.sys.scoker;


import com.alibaba.fastjson2.JSON;
import com.xadmin.sys.entity.WebSocket;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.awt.image.ImageProducer;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
@Component
public class IndexScheduled {

    static int nowOnline= 0;

    Map<String, Object> map1 = new HashMap<>();
    static int yeardata=100;
    static int monthdata=452;
    static int weekdata=230;
    static int daydata=199;
    List<Long> list1 = new ArrayList<>();
    List<Long> list2 = new ArrayList<>();
    List<Long> list3 = new ArrayList<>();
    List<Long> logindata = new ArrayList<>();

    static int flag=0;
    /**
     * 每3秒执行一次
     */
    @Scheduled(cron = "0/2 * * * * ? ") //我这里暂时不需要运行这条定时任务，所以将注解注释了，朋友们运行时记得放开注释啊
    public void nowOnline() {
//        System.err.println("*********   首页定时任务执行   **************");
        CopyOnWriteArraySet<WebSocket> webSocketSet = WebSocket.getWebSocketSet();
        map1.clear();
        list1.clear();
        list2.clear();
        list3.clear();
        logindata.clear();
        for (int i=0;i<3;i++){
            list1.add(Math.round(Math.random()*100));
            list2.add(Math.round(Math.random()*70));
            list3.add(Math.round(Math.random()*30));
        }
        for (int i=0;i<12;i++){
            logindata.add(Math.round(Math.random()*200));
        }

            map1.put("qiandao",Math.round(Math.random()*100));
            map1.put("noqiandao",Math.round(Math.random()*20));
            map1.put("qinjia",Math.round(Math.random()*10));
            map1.put("chuqin1",Math.round(Math.random()*100));
            map1.put("chuqin2",Math.round(Math.random()*100));
            map1.put("chuqin3",Math.round(Math.random()*100));
            map1.put("cepingyou",Math.round(Math.random()*50));
            map1.put("cepingliang",Math.round(Math.random()*70));
            map1.put("cepinghege",Math.round(Math.random()*30));
            map1.put("cepingnohege",Math.round(Math.random()*40));
            map1.put("jichuang1",Math.round(Math.random()*100));
            map1.put("jichuang2",Math.round(Math.random()*100));
            map1.put("jichuang3",Math.round(Math.random()*100));
            map1.put("aqpass1",Math.round(Math.random()*100));
            map1.put("aqpass2",Math.round(Math.random()*60));
            map1.put("aqpass3",Math.round(Math.random()*50));

        map1.put("yeardata",++yeardata);
        map1.put("monthdata",++monthdata);
        map1.put("weekdata",++weekdata);
        map1.put("daydata",++daydata);
        map1.put("jihua",list1);
        map1.put("wanceng",list2);
        map1.put("nowanceng",list3);
        map1.put("logindata",logindata);
//        System.out.println(Math.round(Math.random()*100));

        webSocketSet.forEach(c -> {
            c.sendOneMessage(String.valueOf(777), JSON.toJSONString(map1));//往客户端发送信息
        });
//        System.err.println("........首页定时任务完成.......");
    }
}