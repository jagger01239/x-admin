package com.xadmin.HaiKang;
import com.xadmin.sys.utils.Result;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
@Component
public class TwoClientDemo {
    public void main1() throws ExecutionException, InterruptedException {
        List<Device> devices = addDevice();
        TwoVideoDemo video;
        CameraInfo cameraInfo;
        FutureTask<Result> ft;
        for (int i = 0; i < devices.size(); i++) {
            cameraInfo = new CameraInfo();
            cameraInfo.setAddress(devices.get(i).getIp());
            cameraInfo.setPort((short) 8000);
            cameraInfo.setUserName(devices.get(i).getUserName());
            cameraInfo.setPwd(devices.get(i).getPassWord());
            video = new TwoVideoDemo(cameraInfo);
            ft = new FutureTask<>(video);
            new Thread(ft).start();
            ft.get();
        }
}

    //存储登陆设备集合
    public static List<Device> addDevice() {
        List<Device> list = new ArrayList<>();
        Device device = new Device();
        device.setIp("192.168.1.64"); //改成自己设备的ip 用户名和密码
        device.setUserName("admin");
        device.setPassWord("anhao666");
        list.add(device);
        return list;
    }
 
}