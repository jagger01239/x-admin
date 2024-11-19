package com.xadmin.sys.controller;

import com.xadmin.ClearFolder;
import com.xadmin.HaiKang.TwoClientDemo;
import com.xadmin.sys.arcsoft.ArcsoftUtils;
import com.xadmin.sys.arcsoft.ArcsoftVo;
import com.xadmin.sys.entity.Files;
import com.xadmin.sys.service.IFileService;
import com.xadmin.sys.service.IUserService;
import com.xadmin.sys.utils.ImageBase64Util;
import com.xadmin.sys.utils.Result;
import com.xadmin.sys.utils.cameraFace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.*;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private ClearFolder clearFolder;

    @Autowired
    private IFileService iFileService;

    @Autowired
    private TwoClientDemo twoClientDemo;

    @Autowired
    private IUserService iUserService;

    @Autowired
    private cameraFace camera;
    @GetMapping("/getVideoByid/{id}")
    public Result getVideoByid(@PathVariable Integer id){
        Files files = iFileService.getById(id);
        return Result.success(files);
    }

    @RequestMapping("/torenlianshibie")
    public String torenlianshibie(String base64, String localImageUrl) throws Exception {
        File file = ImageBase64Util.base64ToFile(base64);
        String split[] = localImageUrl.split("/");
//        System.out.println("D:\\myweb\\我的web项目\\x-admin\\"+split[3]+"s"+"\\"+split[4]);
//        System.out.println(file.toString());
        localImageUrl = "C:\\myweb\\x-admin\\"+split[3]+"s"+"\\"+split[4];
        Result result = cameraFace.cameraFaceRecognition(localImageUrl,file.toString());
        System.out.println(result);

        if (result.getCode() == 20000) {
            return "true#"+result.getData();
        } else {
            return "false#"+result.getData();
        }
    }

    @PostMapping ("/paizhao")
    public String HKVideoPaiZhao() throws ExecutionException, InterruptedException {
        clearFolder.main1("C:\\myweb\\x-admin\\Download\\imgs");
        twoClientDemo.main1();
        //获取数据库中所有的人脸特征集
        List<ArcsoftVo> arcsoftVos = iUserService.getAllFacedata();
        System.out.println("开始人脸识别！！");
        String names = "";
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test0.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test1.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test2.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test3.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test4.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test5.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test6.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test7.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test8.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test9.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test10.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test11.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test12.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test13.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test14.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test15.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test16.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test17.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test18.jpeg",arcsoftVos);
        names = names+ArcsoftUtils.getFaceFeatureData2("C:\\myweb\\x-admin\\Download\\imgs\\test19.jpeg",arcsoftVos);
        return names;
    }
}
