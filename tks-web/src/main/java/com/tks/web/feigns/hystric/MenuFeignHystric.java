package com.tks.web.feigns.hystric;

import java.util.List;

import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BRoleInfo;
import com.tks.resource.common.entity.BRoleMenu;
import com.tks.resource.common.entity.MenuTree;
import com.tks.web.feigns.IMenuFeignClient;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.feigns.hystric
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
public class MenuFeignHystric implements IMenuFeignClient {
    @Override
    public List<MenuTree> getMenuList() {
        return null;
    }

    @Override
    public List<BRoleInfo> getRoleList() {
        return null;
    }

    @Override
    public BMenuInfo saveOrUpdateMenu(BMenuInfo tMenuInfo) {
        return null;
    }

    @Override
    public BRoleInfo saveOrUpdateRole(BRoleInfo tRoleInfo) {
        return null;
    }

    @Override
    public List<BRoleMenu> saveOrUpdateRoleMenus(List<BRoleMenu> tRoleMenus) {
        return null;
    }

    @Override
    public int delMenus(List<String> menuKeyList) {
        return 0;
    }

    @Override
    public int delRoles(List<String> roleKeyList) {
        return 0;
    }

    @Override
    public List<String> getMenuCodeByRoleId(String roleId) {
        return null;
    }
}
