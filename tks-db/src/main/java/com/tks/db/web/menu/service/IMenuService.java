package com.tks.db.web.menu.service;



import java.util.List;

import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BRoleInfo;
import com.tks.resource.common.entity.BRoleMenu;
import com.tks.resource.common.entity.MenuTree;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.menu.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
public interface IMenuService {

    List<MenuTree> getMenuList();

    List<BRoleInfo> getRoleList();

    BMenuInfo saveOrUpdateMenu(BMenuInfo tMenuInfo);

    BRoleInfo saveOrUpdateRole(BRoleInfo tRoleInfo);

    List<BRoleMenu> saveOrUpdateRoleMenus(List<BRoleMenu> tRoleMenus);

    int delMenus(List<String> menuKeyList);

    int delRoles(List<String> roleKeyList);

    List<String> getMenuCodeByRoleId(String roleId);
}
