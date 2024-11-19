package com.xadmin.sys.service.impl;

import com.xadmin.sys.entity.Role;
import com.xadmin.sys.entity.RoleMenu;
import com.xadmin.sys.mapper.RoleMenuMapper;
import com.xadmin.sys.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;


    @Override
    public List<Integer> getMenuIdListByRoleId(Integer id) {
        return roleMenuMapper.getMenuIdListByRoleId(id);
    }

    @Override
    public void addMenuList(Role role) {
        if (null != role.getMenuIdList()){
            for (Integer MenuId : role.getMenuIdList()){
                roleMenuMapper.insert(new RoleMenu(null,role.getRoleId(),MenuId));
            }
        }
    }
}
