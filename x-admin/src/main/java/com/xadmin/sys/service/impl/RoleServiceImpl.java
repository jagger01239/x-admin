package com.xadmin.sys.service.impl;

import com.baomidou.mybatisplus.generator.config.INameConvert;
import com.xadmin.sys.entity.Role;
import com.xadmin.sys.entity.RoleMenu;
import com.xadmin.sys.mapper.RoleMapper;
import com.xadmin.sys.mapper.RoleMenuMapper;
import com.xadmin.sys.service.IRoleMenuService;
import com.xadmin.sys.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cdf
 * @since 2023-06-23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Transactional
    @Override
    public void addRole(Role role) {
        this.save(role);
        if (null != role.getMenuIdList()){
            for (Integer MenuId : role.getMenuIdList()){
                roleMenuMapper.insert(new RoleMenu(null,role.getRoleId(),MenuId));
            }
        }
    }
}
