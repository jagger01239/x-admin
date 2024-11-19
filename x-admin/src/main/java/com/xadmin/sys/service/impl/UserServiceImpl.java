package com.xadmin.sys.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xadmin.sys.arcsoft.ArcsoftVo;
import com.xadmin.sys.entity.Menu;
import com.xadmin.sys.entity.User;
import com.xadmin.sys.entity.UserRole;
import com.xadmin.sys.mapper.UserMapper;
import com.xadmin.sys.mapper.UserRoleMapper;
import com.xadmin.sys.service.IMenuService;
import com.xadmin.sys.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xadmin.sys.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.TimeUnit;



/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private IMenuService menuService;

    @Override
    public Map<String, Object> login(User user) {
        //根据用户名和密码登录
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper();
        wrapper.eq(User::getUsername,user.getUsername());
        wrapper.eq(User::getPassword,user.getPassword());
        User loginUser = this.getOne(wrapper);
        //如果登录成功，则生成taken，并将用户信息存入jwt
        if(loginUser != null){
            Map<String, Object> data = new HashMap<>();
            loginUser.setPassword(null);
            String jwt = jwtUtil.createToken(loginUser); //使用JWT
            data.put("token", jwt);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getUserInfo(String token) {
        User user = null;
        try {
            user = jwtUtil.parseToken(token,User.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(user != null){
            Map<String, Object> data =  new HashMap<>();
            data.put("name",user.getUsername());
            data.put("avatar",user.getAvatar());
            //获取角色列表
            List<String> roleList = this.getBaseMapper().getRoleNamesByUserId(user.getId());
            data.put("roles", roleList);
            //权限列表
            List<Menu> menuList = menuService.getMenuListByUserId(user.getId());
            data.put("menuList",menuList);
            return data;
        }
        return null;
    }

    @Override
    public void logout(String token) {
        //redisTemplate.delete(token);
    }

    @Override
    @Transactional
    public boolean addUser(User user) {
        //写入用户表
        this.save(user);
        //写入角色表
        List<Integer> roleIdList = user.getRoleIdList();
        if (roleIdList != null){
            for (Integer roleid : roleIdList){
                userRoleMapper.insert(new UserRole(null,user.getId(),roleid));
            }
            return true;
        }
        return false;
    }

    @Override
    public User getUSerById(Integer id) {
        User user = this.getById(id);
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId,id);
        List<UserRole> userRoleList = new ArrayList<>();
        userRoleList = userRoleMapper.selectList(wrapper);
        List<Integer> roleIdList = new ArrayList<>();
        for (UserRole userRole : userRoleList){
            roleIdList.add(userRole.getRoleId());
        }
        user.setRoleIdList(roleIdList);
        return user;
    }

    @Override
    @Transactional
    public boolean updateUser(User user) {
        this.updateById(user);
        //删除所有角色
        LambdaQueryWrapper<UserRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(UserRole::getUserId,user.getId());
        userRoleMapper.delete(wrapper);
        //新增角色
        List<Integer> roleIdList = user.getRoleIdList();
        if (roleIdList != null){
            for (Integer roleId : roleIdList){
                userRoleMapper.insert(new UserRole(null,user.getId(),roleId));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUserById(Integer id) {
        this.removeById(id);
        LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(UserRole::getUserId,id);
        userRoleMapper.delete(queryWrapper);
        return true;
    }

    @Override
    public List<ArcsoftVo> getAllFacedata() {
        List<ArcsoftVo> arcsoftVos = new ArrayList<>();
        arcsoftVos = userMapper.getAllFacedata();
        return arcsoftVos;
    }

    @Override
    public int addUser(String username, String phonenumber, String userid, String facedata, String deptid) {
        return userMapper.addUser(username, phonenumber, userid, facedata, deptid);
    }
}
