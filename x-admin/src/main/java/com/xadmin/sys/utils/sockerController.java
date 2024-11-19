//package com.example.demo2.Controller;
//
//import cn.hutool.json.JSONUtil;
//import com.alibaba.fastjson2.JSON;
//import com.alibaba.fastjson2.JSONArray;
//import com.alibaba.fastjson2.JSONObject;
//import org.opencv.core.Core;
//import org.opencv.core.CvType;
//import org.opencv.core.Mat;
//import org.opencv.highgui.HighGui;
//import org.opencv.imgcodecs.Imgcodecs;
//import org.opencv.objdetect.CascadeClassifier;
//import org.springframework.stereotype.Controller;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.*;
//import java.net.Socket;
//import java.util.ArrayList;
//
//import static com.sun.xml.internal.ws.model.RuntimeModeler.PORT;
//import static org.springframework.http.HttpHeaders.HOST;
//
//
//public class sockerController {
//
//    public static void main(String[] args) {
//        Object o = remoteCall("./hatPictrue/hat3.jpg");
//        System.out.println(o.toString());
//    }
//    private static Object remoteCall(String content) {
//        // 加载OpenCV本地库
////        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
////        // 从配置文件lbpcascade_frontalface.xml中创建一个人脸识别器，文件位于opencv安装目录中
////        CascadeClassifier faceDetector = new CascadeClassifier("C:\\softWare\\opencv\\opencv\\sources\\data\\haarcascades\\haarcascade_frontalface_alt.xml");
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("content", content);
//        String str = jsonObject.toJSONString();
//        // 访问服务进程的套接字
//        Socket socket = null;
////        List<Question> questions = new ArrayList<>();
////        log.info("调用远程接口:host=>"+HOST+",port=>"+PORT);
//        System.out.println("调用远程接口:host=>" + "192.168.1.121" + ",port=>" + 12345);
//        try {
//            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
//            socket = new Socket("192.168.1.121", 12345);
//            // 获取输出流对象
//            OutputStream os = socket.getOutputStream();
//            PrintStream out = new PrintStream(os);
//            // 发送内容
//            out.print(str);
//            // 告诉服务进程，内容发送完毕，可以开始处理
//            out.print("over");
//            // 获取服务进程的输入流
//            InputStream is = socket.getInputStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
//            String tmp = null;
//            StringBuilder sb = new StringBuilder();
//            // 读取内容
//            while ((tmp = br.readLine()) != null)
//                sb.append(tmp).append('\n');
//            // 解析结果
////            JSONArray res = JSON.parseArray(sb.toString());
//            String res = sb.toString();
//            File file = ImageBase64Util.base64ToFile(res);
//            System.out.println(file.toString());
////            System.out.println(sb.toString());
////            res = res.replace("}", "");
////            res = res.replace("{", "");
////            String[] str1 = res.split(",");
////            String Str = "";
////            for (int i = 0; i < str1.length; i++) {
////                JSONObject json = JSONUtil.toBean("{" + str1[i] + "}", JSONObject.class);///json字符串转Json对象！！！！！！
//////                System.out.println(json.get("resultUrl" + i));
////                if (i != str1.length-1)
////                    Str = Str + json.get("resultUrl" + i) + "#";
////                else
////                    Str = Str + json.get("resultUrl" + i);
////            }
//            return res;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                if (socket != null) socket.close();
//            } catch (IOException e) {
//            }
////            log.info("远程接口调用结束.");
//            System.out.println();
//        }
//        return null;
//    }
//}
