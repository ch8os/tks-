package com.tks.web.menu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BRoleInfo;
import com.tks.resource.common.entity.BRoleMenu;
import com.tks.resource.freamwork.BusinessResult;
import com.tks.web.menu.service.impl.MenuServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ Purpose:
 * @Package Name: com.tks.web.menu.controller
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
    BusinessResult getMenuList() {
        return BusinessResult.success(menuService.getMenuList());
    }

    @ApiOperation(value = "获取所有角色信息", notes = "")
    @RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
    BusinessResult getRoleList() {
        return BusinessResult.success(menuService.getRoleList());
    }

    @ApiOperation(value = "保存菜单信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateMenu", method = RequestMethod.POST)
    BusinessResult saveOrUpdateMenu(@RequestBody BMenuInfo tMenuInfo) {
        return BusinessResult.success(menuService.saveOrUpdateMenu(tMenuInfo));
    }

    @ApiOperation(value = "保存角色信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateRole", method = RequestMethod.POST)
    BusinessResult saveOrUpdateRole(@RequestBody BRoleInfo tRoleInfo) {
        return BusinessResult.success(menuService.saveOrUpdateRole(tRoleInfo));
    }

    @ApiOperation(value = "保存角色菜单信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateRoleMenus", method = RequestMethod.POST)
    BusinessResult saveOrUpdateRoleMenus(@RequestBody List<BRoleMenu> tRoleMenus) {
        return BusinessResult.success(menuService.saveOrUpdateRoleMenus(tRoleMenus));
    }

    @ApiOperation(value = "删除菜单数据", notes = "")
    @RequestMapping(value = "/delMenus", method = RequestMethod.POST)
    BusinessResult delMenus(@RequestBody List<String> menuKeyList) {
        return BusinessResult.success(menuService.delMenus(menuKeyList));
    }

    @ApiOperation(value = "删除角色数据", notes = "")
    @RequestMapping(value = "/delRoles", method = RequestMethod.POST)
    BusinessResult delRoles(@RequestBody List<String> roleKeyList) {
        return BusinessResult.success(menuService.delRoles(roleKeyList));
    }

    @ApiOperation(value = "根据角色获取菜单信息", notes = "")
    @RequestMapping(value = "/getMenuCodeByRoleId", method = RequestMethod.GET)
    BusinessResult getMenuCodeByRoleId(@RequestParam(value = "roleId") String roleId) {
        return BusinessResult.success(menuService.getMenuCodeByRoleId(roleId));
    }
}
