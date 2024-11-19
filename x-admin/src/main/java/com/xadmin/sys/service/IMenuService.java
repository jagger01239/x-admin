package com.xadmin.sys.service;

import com.xadmin.sys.entity.Menu;
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
public interface IMenuService extends IService<Menu> {
    public List<Menu> getAllMenu();

    public List<Menu> getMenuListByUserId(Integer userId);
}
