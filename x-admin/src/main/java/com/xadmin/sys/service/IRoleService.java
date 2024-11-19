package com.xadmin.sys.service;

import com.xadmin.sys.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
public interface IRoleService extends IService<Role> {

    void addRole(Role role);
}
