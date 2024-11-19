package com.xadmin.sys.arcsoft;

import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FaceFeature;
import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.FaceSimilar;
import com.arcsoft.face.enums.CompareModel;
import com.arcsoft.face.enums.DetectModel;
import com.arcsoft.face.enums.ErrorInfo;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.arcsoft.face.toolkit.ImageInfoEx;

import com.xadmin.EXP.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static com.arcsoft.face.toolkit.ImageFactory.getRGBData;


@Component
public class ArcsoftUtils {

    private static final Logger logger = LoggerFactory.getLogger(ArcsoftUtils.class);

    //1.单例模式 声明虹软引擎 用volatile 修饰 faceEngine
    private static FaceEngine faceEngine;


    private static FaceSimilar faceSimilar = new FaceSimilar();

    //2.单例模式 懒汉改进 双重if，降低锁的竞争频率
    public static FaceEngine getInstance() {
        if (faceEngine == null) {
            faceEngine = ArcsoftConfig.init();
        }
        return faceEngine;
    }

    //1.根据bytes获取人脸特征码
    public static String getFaceFeatureData(byte[] bytes) {
        //虹软人脸检测 检测图片是否合法
        ImageInfo imageInfo = getRGBData(bytes);
        if (imageInfo == null) {
            logger.info("图片不合法");
            throw new ServiceException("图片不合法！");
        }
        List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
        //获取人脸引擎
        faceEngine = getInstance();
        int errorCode = faceEngine.detectFaces(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(), imageInfo.getImageFormat(), faceInfoList);
        //检测到图片中是否有人脸
        if (errorCode == ErrorInfo.MOK.getValue() && faceInfoList.size() > 0) {
            //提取人脸特征
            FaceFeature faceFeature = new FaceFeature();
            faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(),
                    imageInfo.getImageFormat(), faceInfoList.get(0), faceFeature);
            return Base64.getEncoder().encodeToString(faceFeature.getFeatureData());
        } else {
            logger.info("检测到图片无人脸特征");
            throw new ServiceException("检测到图片无人脸特征！");
        }
    }

    //2.根据照片地址获取人脸特征码
    public static String getFaceFeatureData2(String photoImg,List<ArcsoftVo> arcsoftVos) {

        String names = "";
        if(photoImg == null || photoImg == ""){
            logger.info("photoImg为空");
//            throw new ServiceException("请先上传图片！");
            return "";
        }
        photoImg =  photoImg;
        File file = new File(photoImg);
        //判断文件是否存在
        if (!file.exists()) {
            logger.info("图片不存在");
            return "";
//            throw new ServiceException("图片不存在！");
        }
        // 人脸检测
        ImageInfo imageInfo = ImageFactory.getRGBData(new File(photoImg));
        List<FaceInfo> faceInfoList = new ArrayList<FaceInfo>();
        ImageInfoEx imageInfoEx = new ImageInfoEx();
        imageInfoEx.setHeight(imageInfo.getHeight());
        imageInfoEx.setWidth(imageInfo.getWidth());
        imageInfoEx.setImageFormat(imageInfo.getImageFormat());
        imageInfoEx.setImageDataPlanes(new byte[][]{imageInfo.getImageData()});
        imageInfoEx.setImageStrides(new int[]{imageInfo.getWidth() * 3});
        //获取虹软引擎对象
        FaceEngine faceEngine = getInstance();
        try {
            int errorCode = faceEngine.detectFaces(imageInfoEx, DetectModel.ASF_DETECT_MODEL_RGB, faceInfoList);
            System.out.println("图片中检测到=={"+faceInfoList.size()+"}==个人脸信息");
            //获取数据库中所有的人脸特征集
            if (errorCode == ErrorInfo.MOK.getValue() && faceInfoList.size() > 0) {
                // 检测到图片中有人脸，提取人脸特征
                for (int i=0;i<=faceInfoList.size()-1;i++){
                    FaceFeature faceFeature = new FaceFeature();
                    faceEngine.extractFaceFeature(imageInfo.getImageData(), imageInfo.getWidth(), imageInfo.getHeight(),
                            imageInfo.getImageFormat(), faceInfoList.get(i), faceFeature);
                    String s = Base64.getEncoder().encodeToString(faceFeature.getFeatureData());
                    ArcsoftVo ao = faceComparison(s,arcsoftVos);
                    if (ao != null){
                        names = names+ao.getData()+",";
                    }
                    logger.info("转换的人脸特征码为：" + s);
                }
                return names;
            }
            logger.info("未检测出人脸");
        } catch (Exception e) {
            logger.info("图片不合法！");
            e.printStackTrace();
        }
        return "";
    }

    //3.根据特征码遍历人脸集获取相匹配的数据
    public static ArcsoftVo faceComparison(String featureData, List<ArcsoftVo> arcsoftVos) {
        FaceFeature faceFeature = new FaceFeature();
        faceFeature.setFeatureData(Base64.getMimeDecoder().decode(featureData));
        FaceFeature targetFaceFeature = new FaceFeature();
        //遍历人脸集，进行比对
        for (ArcsoftVo ao:arcsoftVos) {
            if (ao.getFeatureData() == null) {
                continue;
            }
            targetFaceFeature.setFeatureData(Base64.getMimeDecoder().decode(ao.getFeatureData()));
            int errorCode = faceEngine.compareFaceFeature(targetFaceFeature, faceFeature, CompareModel.LIFE_PHOTO,
                    faceSimilar);
            if (errorCode == 0 && faceSimilar.getScore() >= 0.80) {
                ao.setSimilarity(faceSimilar.getScore());
                logger.info("本次人脸匹配成功：{  "+ao.getData()+"  }");
                // 匹配成功
                return ao;
            }
        }
        logger.info("人脸数据集已循环完毕无匹配！");
        return null;
    }

    //4.根据特征码进行人脸比对
    public boolean faceComparison(String afeatureData, String bfeatureData) {
        FaceFeature faceFeature = new FaceFeature();
        faceFeature.setFeatureData(Base64.getMimeDecoder().decode(afeatureData));
        FaceFeature targetFaceFeature = new FaceFeature();
        //进行比对
        targetFaceFeature.setFeatureData(Base64.getMimeDecoder().decode(bfeatureData));
        int errorCode = faceEngine.compareFaceFeature(targetFaceFeature, faceFeature, CompareModel.LIFE_PHOTO,
                faceSimilar);
        if (errorCode == 0 && faceSimilar.getScore() >= 0.80) {
            // 匹配成功
            return true;
        }
        return false;
    }

    public static byte[] base64Hbyte(String base){
        //图片Base64和byte[]数组
        int i = base.indexOf("base64,") + 7;
        System.out.println(i);
        String newBase64 = base.substring(i, base.length());
        byte[] bytes = new byte[0];
        bytes = DatatypeConverter.parseBase64Binary(newBase64);
        return bytes;
    }

}
