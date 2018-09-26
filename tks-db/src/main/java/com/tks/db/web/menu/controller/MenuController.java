package com.tks.db.web.menu.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tks.db.web.menu.service.impl.MenuServiceImpl;
import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BRoleInfo;
import com.tks.resource.common.entity.BRoleMenu;
import com.tks.resource.common.entity.MenuTree;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.menu.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@RestController
@RequestMapping("/menu")
@Api(description = "用户菜单角色业务处理")
public class MenuController {
    @Autowired
    MenuServiceImpl menuService;

    @ApiOperation(value = "获取菜单树", notes = "")
    @RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
    List<MenuTree> getMenuList() {
        return menuService.getMenuList();
    }

    @ApiOperation(value = "获取所有角色信息", notes = "")
    @RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
    List<BRoleInfo> getRoleList() {
        return menuService.getRoleList();
    }

    @ApiOperation(value = "保存菜单信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateMenu", method = RequestMethod.POST)
    BMenuInfo saveOrUpdateMenu(@RequestBody BMenuInfo tMenuInfo) {
        return menuService.saveOrUpdateMenu(tMenuInfo);
    }

    @ApiOperation(value = "保存角色信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateRole", method = RequestMethod.POST)
    BRoleInfo saveOrUpdateRole(@RequestBody BRoleInfo tRoleInfo) {
        return menuService.saveOrUpdateRole(tRoleInfo);
    }

    @ApiOperation(value = "保存角色菜单信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateRoleMenus", method = RequestMethod.POST)
    List<BRoleMenu> saveOrUpdateRoleMenus(@RequestBody List<BRoleMenu> tRoleMenus) {
        return menuService.saveOrUpdateRoleMenus(tRoleMenus);
    }

    @ApiOperation(value = "删除菜单数据", notes = "")
    @RequestMapping(value = "/delMenus", method = RequestMethod.POST)
    int delMenus(@RequestBody List<String> menuKeyList) {
        return menuService.delMenus(menuKeyList);
    }

    @ApiOperation(value = "删除角色数据", notes = "")
    @RequestMapping(value = "/delRoles", method = RequestMethod.POST)
    int delRoles(@RequestBody List<String> roleKeyList) {
        return menuService.delRoles(roleKeyList);
    }

    @ApiOperation(value = "根据角色获取菜单信息", notes = "")
    @RequestMapping(value = "/getMenuCodeByRoleId", method = RequestMethod.GET)
    List<String> getMenuCodeByRoleId(@RequestParam(value = "roleId") String roleId) {
        return menuService.getMenuCodeByRoleId(roleId);
    }

    ;


}
