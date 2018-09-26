package com.tks.web.feigns;

import com.tks.resource.common.entity.MenuTree;
import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BRoleInfo;
import com.tks.resource.common.entity.BRoleMenu;
import com.tks.web.feigns.hystric.MenuFeignHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.feigns
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@FeignClient(value = "tks-db", fallback = MenuFeignHystric.class)
public interface IMenuFeignClient {

    @RequestMapping(value = "/menu/getMenuList", method = RequestMethod.POST)
    List<MenuTree> getMenuList();

    @RequestMapping(value = "/menu/getRoleList", method = RequestMethod.POST)
    List<BRoleInfo> getRoleList();

    @RequestMapping(value = "/menu/saveOrUpdateMenu", method = RequestMethod.POST)
    BMenuInfo saveOrUpdateMenu(@RequestBody BMenuInfo tMenuInfo);

    @RequestMapping(value = "/menu/saveOrUpdateRole", method = RequestMethod.POST)
    BRoleInfo saveOrUpdateRole(@RequestBody BRoleInfo tRoleInfo);

    @RequestMapping(value = "/menu/saveOrUpdateRoleMenus", method = RequestMethod.POST)
    List<BRoleMenu> saveOrUpdateRoleMenus(@RequestBody List<BRoleMenu> tRoleMenus);

    @RequestMapping(value = "/menu/delMenus", method = RequestMethod.POST)
    int delMenus(@RequestBody List<String> menuKeyList);

    @RequestMapping(value = "/menu/delRoles", method = RequestMethod.POST)
    int delRoles(@RequestBody List<String> roleKeyList);

    @RequestMapping(value = "/menu/getMenuCodeByRoleId", method = RequestMethod.GET)
    List<String> getMenuCodeByRoleId(@RequestParam(value = "roleId") String roleId);
}
