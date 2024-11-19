package com.xadmin.HaiKang;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByteByReference;
import com.xadmin.HaiKang.CameraInfo;
import com.xadmin.HaiKang.HCNetSDK;
import com.xadmin.sys.utils.Result;

import java.util.Date;
import java.util.concurrent.Callable;
public class TwoVideoDemo implements Callable<Result> {
    //初始化
    public static final HCNetSDK INSTANCE = HCNetSDK.INSTANCE;
    private static short wPicSize=0xff;///* 0=CIF, 1=QCIF, 2=D1 3=UXGA(1600x1200), 4=SVGA(800x600), 5=HD720p(1280x720),6=VGA*/
    private static short wPicQuality=0;// 图片质量系数 0-最好 1-较好 2-一般
    static HCNetSDK sdk;
    private CameraInfo cameraInfo;
    public TwoVideoDemo(CameraInfo cameraInfo) {
        this.cameraInfo = cameraInfo;
    }
    @Override
    public Result call() throws Exception {
        sdk = INSTANCE;
        if (!sdk.NET_DVR_Init()) {
            System.out.println("初始化失败..................");
        }
        //创建设备
        HCNetSDK.NET_DVR_DEVICEINFO_V30 deInfo = new HCNetSDK.NET_DVR_DEVICEINFO_V30();
        //注册用户设备
        Integer id = sdk.NET_DVR_Login_V30(cameraInfo.getAddress(), cameraInfo.getPort(),
                cameraInfo.getUserName(), cameraInfo.getPwd(), deInfo);
        cameraInfo.setUserId(id);
        //判断是否注册成功
        if (cameraInfo.getUserId().intValue() < 0) {
            System.out.println("注册设备失败 错误码为:"+sdk.NET_DVR_GetLastError());
        } else {
            System.out.println("注册成功---Id为:" + cameraInfo.getUserId().intValue());
        }
        //判断是否获取到设备能力
        HCNetSDK.NET_DVR_WORKSTATE_V30 devWork = new HCNetSDK.NET_DVR_WORKSTATE_V30();
        if (!sdk.NET_DVR_GetDVRWorkState_V30(cameraInfo.getUserId(), devWork)) {
            System.out.println("获取设备能力集失败,返回设备状态失败..............." + "错误码为:" + sdk.NET_DVR_GetLastError());
        }
        //启动实时预览功能  创建clientInfo对象赋值预览参数
        HCNetSDK.NET_DVR_CLIENTINFO clientInfo = new HCNetSDK.NET_DVR_CLIENTINFO();
        clientInfo.lChannel = 1;   //设置通道号
        clientInfo.lLinkMode = 0;  //TCP取流
        clientInfo.sMultiCastIP = null;//不启动多播模式
        clientInfo.hPlayWnd = null;//创建窗口句柄
        int n = 0;
        while (n<10){
            HCNetSDK.NET_DVR_JPEGPARA cs=new HCNetSDK.NET_DVR_JPEGPARA();
            cs.wPicSize=wPicSize;
            cs.wPicQuality=wPicQuality;
            String fileName="C:\\myweb\\x-admin\\Download\\imgs\\test"+n+".jpeg";
            Thread.sleep(500);
            boolean pz=sdk.NET_DVR_CaptureJPEGPicture(id, clientInfo.lChannel, cs, fileName.getBytes());
            if(pz){
                System.out.println("保存成功！");
            }else {
                System.out.println("抓拍失败!" + " err: " + sdk.NET_DVR_GetLastError());
            }
            n++;
        }
        return Result.success("",null);
    }
    /**
     * @param预览回调接口实现类
     */
    //停止录制
    static void stopRecord(Integer i) {
        sdk.NET_DVR_Logout(i);
        sdk.NET_DVR_StopRealPlay(i);
        sdk.NET_DVR_Cleanup();
    }
}