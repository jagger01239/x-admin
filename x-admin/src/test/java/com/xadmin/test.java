//package com.xadmin;//package com.xadmin;
////
////import com.baomidou.mybatisplus.generator.FastAutoGenerator;
////import com.baomidou.mybatisplus.generator.config.OutputFile;
////import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
////import org.junit.jupiter.api.Test;
////import org.springframework.boot.test.context.SpringBootTest;
////
////import java.util.Collections;
////
////@SpringBootTest
////public class test {
////    @Test
////    public static void main(String[] args) {
////        String url = "jdbc:mysql:///xdb";
////        String username = "root";
////        String password = "0516";
////        String author = "cdf";
////        String outputDir = "D:\\我的web项目\\x-admin\\src\\main\\java";
////        String basePackage = "com.xadmin";
////        String moduleName = "sys";
////        String mapperLocation = "D:\\我的web项目\\x-admin\\src\\main\\resources\\mapper\\"+moduleName;
////        String tableName = "x_user,x_menu,x_role,x_role_menu,x_user_role";
////        String tablePrefix = "x_";
////        FastAutoGenerator.create(url, username, password)
////                .globalConfig(builder -> {
////                    builder.author(author) // 设置作者
////                            .enableSwagger() // 开启 swagger 模式
////                            //.fileOverride() // 覆盖已生成文件
////                            .outputDir(outputDir); // 指定输出目录
////                })
////                .packageConfig(builder -> {
////                    builder.parent(basePackage) // 设置父包名
////                            .moduleName(moduleName) // 设置父包模块名
////                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
////                })
////                .strategyConfig(builder -> {
////                    builder.addInclude(tableName) // 设置需要生成的表名
////                            .addTablePrefix(tablePrefix); // 设置过滤表前缀
////                })
////                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
////                .execute();
////
////    }
////}
//
//
//
//
//
//
//import org.bytedeco.javacv.FFmpegFrameGrabber;
//import org.bytedeco.javacv.Frame;
//import org.bytedeco.javacv.FrameGrabber;
//import org.bytedeco.javacv.Java2DFrameConverter;
//import org.junit.jupiter.api.Test;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.Socket;
//
//public class test {
//    private static final String IP_ADDRESS = "192.168.1.64";
//    private static final int PORT = 8000;
//
//
//    @Test
//    public static void main(String[] args) {
//        try {
//            Socket socket = new Socket(IP_ADDRESS, PORT);
//            InputStream inputStream = socket.getInputStream();
//            System.out.println(inputStream);
//            // 处理视频流数据
//            handleVideoStream(inputStream);
//            inputStream.close();
//            socket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void handleVideoStream(InputStream inputStream) {
//        System.out.println("截取图片");
//        try {
//            // 使用FrameGrab来解码视频
//            FrameGrab grab = FrameGrab.createFrameGrab(inputStream);
//
//            // 获取第一帧（可根据需求适当修改）
//            Picture picture = grab.getNativeFrame();
//
//            // 将Picture转换为BufferedImage
//            BufferedImage bufferedImage = AWTUtil.toBufferedImage(picture);
//
//            // 保存截取的帧为图片文件
//            String outputImagePath = "path/to/output.jpg";
//            ImageIO.write(bufferedImage, "jpg", new File(outputImagePath));
//
//            System.out.println("视频帧截取成功，保存路径为：" + outputImagePath);
//        } catch (IOException | JCodecException e) {
//            e.printStackTrace();
//        }
//        // 处理视频流数据的逻辑
//    }
//
//
//}
