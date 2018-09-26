package com.tks.web.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BRoleInfo;
import com.tks.resource.common.entity.BRoleMenu;
import com.tks.resource.common.entity.MenuTree;
import com.tks.web.feigns.IMenuFeignClient;
import com.tks.web.menu.service.IMenuService;

/**
 * @ Purpose:
 * @Package Name: com.tks.db.web.menu.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    IMenuFeignClient feignClient;

    @Override
    public List<MenuTree> getMenuList() {
        return feignClient.getMenuList();
    }

    @Override
    public List<BRoleInfo> getRoleList() {
        return feignClient.getRoleList();
    }

    @Override
    public BMenuInfo saveOrUpdateMenu(BMenuInfo tMenuInfo) {
        return feignClient.saveOrUpdateMenu(tMenuInfo);
    }

    @Override
    public BRoleInfo saveOrUpdateRole(BRoleInfo tRoleInfo) {
        return feignClient.saveOrUpdateRole(tRoleInfo);
    }

    @Override
    public List<BRoleMenu> saveOrUpdateRoleMenus(List<BRoleMenu> tRoleMenus) {
        return feignClient.saveOrUpdateRoleMenus(tRoleMenus);
    }

    @Override
    public int delMenus(List<String> menuKeyList) {
        return feignClient.delMenus(menuKeyList);
    }

    @Override
    public int delRoles(List<String> roleKeyList) {
        return feignClient.delRoles(roleKeyList);
    }

    @Override
    public List<String> getMenuCodeByRoleId(String roleId) {
        return feignClient.getMenuCodeByRoleId(roleId);
    }
}
