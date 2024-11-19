package com.xadmin.sys.service;

import com.xadmin.sys.entity.Role;
import com.xadmin.sys.entity.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
public interface IRoleMenuService extends IService<RoleMenu> {

    List<Integer> getMenuIdListByRoleId(Integer id);

    void addMenuList(Role role);
}
