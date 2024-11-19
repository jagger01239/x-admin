package com.xadmin.sys.service;

import com.xadmin.sys.arcsoft.ArcsoftVo;
import com.xadmin.sys.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
public interface IUserService extends IService<User> {

    Map<String, Object> login(User user);

    Map<String, Object> getUserInfo(String token);

    void logout(String token);

    boolean addUser(User user);

    User getUSerById(Integer id);

    boolean updateUser(User user);

    boolean deleteUserById(Integer id);

    List<ArcsoftVo> getAllFacedata();

    int addUser(String username, String phonenumber, String userid, String facedata, String deptid);
}
