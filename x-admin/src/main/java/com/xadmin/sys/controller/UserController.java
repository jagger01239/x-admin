package com.xadmin.sys.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xadmin.sys.arcsoft.ArcsoftUtils;
import com.xadmin.sys.entity.User;
import com.xadmin.sys.service.IUserService;
import com.xadmin.sys.utils.Result;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
@RestController
@RequestMapping("/user")
//@CrossOrigin //解决跨域
public class UserController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("/getAllUser")
    public Result<List<User>> getAllUser(){
        List<User> users = iUserService.list();
        return Result.success(users);
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody User user){
        Map<String,Object> data = iUserService.login(user);
        if(data != null){
            System.out.println(data);
            return Result.success(data);//????
        }
        return Result.fail(20002,"用户名或密码错误");
    }

    @GetMapping("/info")
    public Result<?> getUserInfo(@Param("token") String token){
        Map<String,Object> data = iUserService.getUserInfo(token);
        if(data != null){
            return Result.success(data);
        }
        return Result.fail(20003,"用户信息获取失败");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        iUserService.logout(token);
        return Result.success("注销成功");
    }

    @GetMapping("/list")
    public Result<?> getUserListPage(@RequestParam(value = "username", required = false) String username,
                                     @RequestParam(value = "phone", required = false) String phone,
                                     @RequestParam("pageNo") Long pageNo,
                                     @RequestParam("pageSize") Long pageSize) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.eq(StringUtils.hasLength(username), User::getUsername, username);
        wrapper.eq(StringUtils.hasLength(phone), User::getPhone, phone);
        wrapper.orderByDesc(User::getId);
        Page<User> page = new Page<>(pageNo, pageSize);
        iUserService.page(page, wrapper);
        Map<String, Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());
        return Result.success(data);
    }

    @PostMapping("/addUser")
    public Result<?> addUser(@RequestBody User user){
        boolean flag = iUserService.addUser(user);
        if (flag){
            return Result.success("新增用户成功！！");
        }else {
            return Result.fail("新增用户失败！！");
        }
    }

    @PutMapping("/updateUser")
    public Result<?> updateUser(@RequestBody User user){
        user.setPassword(null);
        boolean flag = iUserService.updateUser(user);
        if (flag){
            return Result.success("修改用户成功！！");
        }else {
            return Result.fail("修改用户失败！！");
        }
    }
    @GetMapping("/getUserById/{id}")
    public Result<?> getUserById(@PathVariable("id") Integer id){
        User user = iUserService.getUSerById(id);
        return Result.success(user);
    }

    @DeleteMapping("/deleteUserById/{id}")
    public Result<?> deleteUserById(@PathVariable("id") Integer id){
        boolean f = iUserService.deleteUserById(id);
        if (f){
            return Result.success("删除用户成功！");
        }else {
            return Result.fail("删除用户失败！！");
        }
    }

    @GetMapping("getUserByNameAndPassword/{name}&{password}")
    public Result getUserByNameAndPassword(@PathVariable("name") String name,@PathVariable("password") String password){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.eq(StringUtils.hasLength(name), User::getUsername, name);
        wrapper.eq(StringUtils.hasLength(password), User::getPassword, password);
        User user = iUserService.getOne(wrapper);
        return Result.success(user);
    }

    @PostMapping("/save")
    public Result save(@RequestBody User user){
        boolean flag = iUserService.updateById(user);
        if (flag){
            return Result.success("修改成功啦！");
        }else {
            return Result.fail("修改失败喽!");
        }
    }



    //拍照注册
    @PostMapping("/PhotoRegister")
    public Result PhotoRegister(String base64,String name,String phone,String id,String gradeid){
        String base64s = base64;
        String username = name;
        String phonenumber = phone;
        String userid = id;
        String deptid = gradeid;
        byte[] base = ArcsoftUtils.base64Hbyte(base64s);
        String facedata = ArcsoftUtils.getFaceFeatureData(base);//获取人脸特征码
        int flag = 0;
        try{
            flag = iUserService.addUser(username,phonenumber,userid,facedata,deptid);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("+++++++++"+flag);
        if (flag == 1){
            return Result.success();
        }else {
            return Result.fail("注册失败，请重新尝试！！");
        }

    }



}
