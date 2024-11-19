package com.xadmin.sys.controller;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.xadmin.sys.utils.ImageBase64Util;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static com.sun.xml.internal.ws.model.RuntimeModeler.PORT;
import static org.springframework.http.HttpHeaders.HOST;


@RestController
@RequestMapping("/jiance")
public class sockerController {

    @Value("${server.ip}")
    private String serverIp;
    @RequestMapping("/startjiance")
    public Object remoteCall(String content){
        String imageStr = "";
        String[] urls = content.split("#");
        for (int i = 0;i < urls.length;i++){
            String[] url2 = urls[i].split("/");
            File file = new File("D:\\myweb\\我的web项目\\x-admin\\files\\"+url2[url2.length-1]);
            if (i<urls.length-1)
                imageStr =imageStr+ImageBase64Util.GetImageStr(file)+"##";
            else
                imageStr =imageStr+ImageBase64Util.GetImageStr(file);
                System.out.println("base64加密一次！！");
        }
        content = imageStr;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", content);
        String str = jsonObject.toJSONString();
        // 访问服务进程的套接字
        Socket socket = null;
        System.out.println("调用远程接口:host=>" + "192.168.1.115" + ",port=>" + 12345);
        try {
            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
            socket = new Socket("192.168.1.115", 12345);
            // 获取输出流对象
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            // 发送内容
            out.print(str);
            // 告诉服务进程，内容发送完毕，可以开始处理
            out.print("over");
            // 获取服务进程的输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String tmp = null;
            StringBuilder sb = new StringBuilder();
            // 读取内容
            while ((tmp = br.readLine()) != null)
                sb.append(tmp).append('\n');
            // 解析结果
            String res = sb.toString();
            String[] ress = res.split("@");
            File file = null;
            String resss = "";
            for(int i=0;i<ress.length;i++){
                file = ImageBase64Util.base64ToFile(ress[i]);
                String[] s = file.toString().split("\\\\");
                String ss = s[s.length-1];
                if (i<ress.length-1)
                    resss = resss+"http://" + serverIp + ":9999/file/s/"+ss+"@";
                else
                    resss = resss+"http://" + serverIp + ":9999/file/s/"+ss;
            }
            System.out.println(resss);
            return resss;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
            }
            System.out.println();
        }
        return null;
    }

    @RequestMapping("/startjianceemotion")
    public Object remoteCall2(String content){
        String imageStr = "";
        String[] urls = content.split("#");
        for (int i = 0;i < urls.length;i++){
            String[] url2 = urls[i].split("/");
            File file = new File("D:\\myweb\\我的web项目\\x-admin\\files\\"+url2[url2.length-1]);
            if (i<urls.length-1)
                imageStr =imageStr+ImageBase64Util.GetImageStr(file)+"##";
            else
                imageStr =imageStr+ImageBase64Util.GetImageStr(file);
            System.out.println("base64加密一次！！");
        }
        content = imageStr;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content", content);
        String str = jsonObject.toJSONString();
        // 访问服务进程的套接字
        Socket socket = null;
        System.out.println("调用远程接口:host=>" + "192.168.1.116" + ",port=>" + 13142);
        try {
            // 初始化套接字，设置访问服务的主机和进程端口号，HOST是访问python进程的主机名称，可以是IP地址或者域名，PORT是python进程绑定的端口号
            socket = new Socket("192.168.1.116", 13142);
            // 获取输出流对象
            OutputStream os = socket.getOutputStream();
            PrintStream out = new PrintStream(os);
            // 发送内容
            out.print(str);
            // 告诉服务进程，内容发送完毕，可以开始处理
            out.print("over");
            // 获取服务进程的输入流
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
            String tmp = null;
            StringBuilder sb = new StringBuilder();
            // 读取内容
            while ((tmp = br.readLine()) != null)
                sb.append(tmp).append('\n');
            // 解析结果
            String res = sb.toString();
            String[] res2 = res.split("%%");
            String[] ress = res2[0].split("@@");
            String res3 = res2[1];
            File file = null;
            String resss = "";
            for(int i=0;i<ress.length;i++){
                file = ImageBase64Util.base64ToFile(ress[i]);
                String[] s = file.toString().split("\\\\");
                String ss = s[s.length-1];
                if (i<ress.length-1)
                    resss = resss+"http://" + serverIp + ":9999/file/s/"+ss+"@";
                else
                    resss = resss+"http://" + serverIp + ":9999/file/s/"+ss;
            }
            System.out.println(resss);
            return resss+"&"+res3.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
            }
            System.out.println();
        }
        return null;
    }
}
