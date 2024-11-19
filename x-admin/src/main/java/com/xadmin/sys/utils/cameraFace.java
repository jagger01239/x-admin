package com.xadmin.sys.utils;

import com.mysql.cj.Session;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class cameraFace {
    @Autowired
    private static VideoCapture videoCapture;
//    static {
//        // 加载OpenCV本地库
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//    }

    static {
        System.load("D:\\DevelopTools\\opencv\\build\\java\\x64\\opencv_java490.dll");
    }

    public static Result cameraFaceRecognition(String localImageUrl, String shexiangtouUrl) throws Exception {
        try {
            // 打开摄像头获取视频流，0 打开默认摄像头
            videoCapture = new VideoCapture(0);
            // 检查是否支持摄像头  true：代表摄像头可以打开  false：不可以打开
            System.out.println(videoCapture.isOpened());
            // 获取摄像头高度
            int height = (int) videoCapture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
            // 获取摄像头宽度
            int width = (int) videoCapture.get(Videoio.CAP_PROP_FRAME_WIDTH);
            if (height == 0 || width == 0) {
                throw new Exception("摄像头不存在");
            }
            // 创建矩阵
            Mat capImg = new Mat();
            // 创建一个临时矩阵
            Mat temp = new Mat();
            // 对比图片   //可以从数据库获取UUID
            String comparedImagePath = localImageUrl;
            // 摄像头拍摄图片
            String loginImagePath = shexiangtouUrl;
            int tag = 0;
            Float result = 0f;
            while ( tag < 1) { //识别十次人脸
                tag++;
                // 对比人脸
                result = cdfhongruan.renlianshibie(loginImagePath, comparedImagePath);
                if (result > 0.80) {
                    return Result.success(result);
                }else {
                    return Result.fail(result);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //  关闭摄像头
            if (videoCapture != null) {
                videoCapture.release();
            }
        }
        return Result.fail(0f);
    }
}
