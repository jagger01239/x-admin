package com.xadmin.sys.arcsoft;

import com.arcsoft.face.ActiveFileInfo;
import com.arcsoft.face.EngineConfiguration;
import com.arcsoft.face.FaceEngine;
import com.arcsoft.face.FunctionConfiguration;
import com.arcsoft.face.enums.DetectMode;
import com.arcsoft.face.enums.DetectOrient;
import com.arcsoft.face.enums.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
public class ArcsoftConfig {
    //虹软配置工程文件
    private static String arcsoft_sdk = "C:\\softWare\\hongruan\\ArcSoft_ArcFace_Java_Windows_x64_V3.0\\libs\\WIN64";
    //虹软应用APP_ID
    private static String APP_ID = "5exipNML1QJggJRRmRyidJRVAysWvQnMSHuby5Au4wUJ";
    //虹软应用SDK_KEY
    private static String SDK_KEY = "JA1seaWZMt3xg7LpyU7QwjAK3rxXhv2gHk8bLWCjpoFe";

    private static final Logger logger = LoggerFactory.getLogger(ArcsoftConfig.class);

    //创建虹软人脸引擎
    public static FaceEngine init() {
        try {
            FaceEngine faceEngine = new FaceEngine(arcsoft_sdk);
            // 获取激活文件信息
            ActiveFileInfo activeFileInfo = new ActiveFileInfo();
            int errorCode = faceEngine.getActiveFileInfo(activeFileInfo);
            if (errorCode != ErrorInfo.MOK.getValue() &&
                    errorCode != ErrorInfo.MERR_ASF_ALREADY_ACTIVATED.getValue()) {
                // SDK未激活, 开始在线激活引擎
                errorCode = faceEngine.activeOnline(APP_ID, SDK_KEY);
                if (errorCode != ErrorInfo.MOK.getValue()) {
                    logger.info("虹软sdk激活失败！errorCode:" + errorCode);
                }
            }
            //引擎配置
            EngineConfiguration engineConfiguration = new EngineConfiguration();
            engineConfiguration.setDetectMode(DetectMode.ASF_DETECT_MODE_IMAGE);
            engineConfiguration.setDetectFaceOrientPriority(DetectOrient.ASF_OP_ALL_OUT);
            engineConfiguration.setDetectFaceMaxNum(10);
            engineConfiguration.setDetectFaceScaleVal(16);
            //功能配置
            FunctionConfiguration functionConfiguration = new FunctionConfiguration();
            functionConfiguration.setSupportAge(true);
            functionConfiguration.setSupportFace3dAngle(true);
            functionConfiguration.setSupportFaceDetect(true);
            functionConfiguration.setSupportFaceRecognition(true);
            functionConfiguration.setSupportGender(true);
            functionConfiguration.setSupportLiveness(true);
            functionConfiguration.setSupportIRLiveness(true);
            functionConfiguration.setSupportLiveness(false);
            functionConfiguration.setSupportIRLiveness(false);
            engineConfiguration.setFunctionConfiguration(functionConfiguration);

            //初始化引擎
            errorCode = faceEngine.init(engineConfiguration);
            // 初始化失败
            if (errorCode != ErrorInfo.MOK.getValue()) {
                logger.info("虹软sdk激活失败！errorCode:" + errorCode);
                return null;
            }else{
                return faceEngine;
            }
        } catch (Exception e) {
            logger.info("虹软sdk激活失败！exception:" + e.getMessage());
            return null;
        }
    }

}
