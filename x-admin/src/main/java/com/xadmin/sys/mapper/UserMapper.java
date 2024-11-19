package com.xadmin.sys.mapper;

import com.xadmin.sys.arcsoft.ArcsoftVo;
import com.xadmin.sys.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
public interface UserMapper extends BaseMapper<User> {

    List<ArcsoftVo> getAllFacedata();


    List<String> getRoleNamesByUserId(Integer id);

    int addUser(String username, String phonenumber, String userid, String facedata, String deptid);
}
