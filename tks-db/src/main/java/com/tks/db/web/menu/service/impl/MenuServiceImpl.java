package com.tks.db.web.menu.service.impl;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.tks.db.common.example.BMenuInfoExample;
import com.tks.db.common.example.BRoleInfoExample;
import com.tks.db.common.example.BRoleMenuExample;
import com.tks.db.common.mapper.BMenuInfoMapper;
import com.tks.db.common.mapper.BRoleInfoMapper;
import com.tks.db.common.mapper.BRoleMenuMapper;
import com.tks.db.web.menu.service.IMenuService;
import com.tks.resource.common.entity.BMenuInfo;
import com.tks.resource.common.entity.BRoleInfo;
import com.tks.resource.common.entity.BRoleMenu;
import com.tks.resource.common.entity.MenuTree;
import com.tks.resource.common.utils.UUIDUtils;
import com.tks.resource.freamwork.BusinessException;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.menu.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    BMenuInfoMapper tMenuInfoMapper;
    @Autowired
    BRoleInfoMapper tRoleInfoMapper;
    @Autowired
    BRoleMenuMapper tRoleMenuMapper;


    @Override
    public List<MenuTree> getMenuList() {
        List<MenuTree> menuTrees = new ArrayList<>();
        BMenuInfoExample tMenuInfoExample = new BMenuInfoExample();
        BMenuInfoExample.Criteria criteria = tMenuInfoExample.createCriteria();
        criteria.andLevelEqualTo("0");
        List<BMenuInfo> parentMenu = tMenuInfoMapper.selectByExample(tMenuInfoExample);
        if (!CollectionUtils.isEmpty(parentMenu)) {
            tMenuInfoExample = new BMenuInfoExample();
            BMenuInfoExample.Criteria childCriteria = tMenuInfoExample.createCriteria();
            childCriteria.andParentCodeIn(parentMenu.stream().map(BMenuInfo::getMenuCode).collect(Collectors.toList()));
            childCriteria.andLevelEqualTo("1");
            List<BMenuInfo> childMenu = tMenuInfoMapper.selectByExample(tMenuInfoExample);
            Map<String, List<MenuTree>> map = new HashMap<>();
            if (!CollectionUtils.isEmpty(childMenu)) {
                childMenu.stream().collect(Collectors.groupingBy(BMenuInfo::getParentCode)).forEach((key, list) -> {
                    List<MenuTree> menuChildTree = new ArrayList<>();
                    list.stream().forEach(menu -> {
                        MenuTree menuTree = new MenuTree();
                        BeanUtils.copyProperties(menu, menuTree);
                        menuChildTree.add(menuTree);
                    });
                    map.put(key, menuChildTree);
                });
            }
            parentMenu.parallelStream().forEach(menu -> {
                MenuTree menuTree = new MenuTree();
                BeanUtils.copyProperties(menu, menuTree);
                if (map.containsKey(menu.getMenuCode())) {
                    menuTree.setChildren(map.get(menu.getMenuCode()));
                }
                menuTrees.add(menuTree);
            });
        }
        if (!CollectionUtils.isEmpty(menuTrees)) {
            Collections.sort(menuTrees, Comparator.comparing(MenuTree::getMenuCode));
        }
        return menuTrees;
    }

    @Override
    public List<BRoleInfo> getRoleList() {
        BRoleInfoExample tRoleInfoExample = new BRoleInfoExample();
        BRoleInfoExample.Criteria criteria = tRoleInfoExample.createCriteria();
        criteria.andEnabledEqualTo("1");
        return tRoleInfoMapper.selectByExample(tRoleInfoExample);
    }

    @Override
    public BMenuInfo saveOrUpdateMenu(BMenuInfo tMenuInfo) {
        if (ObjectUtils.isEmpty(tMenuInfo))
            throw new BusinessException("传参错误");
        if (StringUtils.isEmpty(tMenuInfo.getId())) {
            tMenuInfo.setId(UUIDUtils.getUUID());
            tMenuInfoMapper.insert(tMenuInfo);
        } else {
            tMenuInfoMapper.updateByPrimaryKey(tMenuInfo);
        }
        return tMenuInfo;
    }

    @Override
    public BRoleInfo saveOrUpdateRole(BRoleInfo tRoleInfo) {
        if (ObjectUtils.isEmpty(tRoleInfo))
            throw new BusinessException("传参错误");
        if (StringUtils.isEmpty(tRoleInfo.getId())) {
            tRoleInfo.setId(UUIDUtils.getUUID());
            tRoleInfoMapper.insert(tRoleInfo);
        } else {
            tRoleInfoMapper.updateByPrimaryKey(tRoleInfo);
        }
        return tRoleInfo;
    }

    @Override
    public List<BRoleMenu> saveOrUpdateRoleMenus(List<BRoleMenu> tRoleMenus) {
        if (ObjectUtils.isEmpty(tRoleMenus))
            throw new BusinessException("传参错误");
        BRoleMenuExample tRoleMenuExample = new BRoleMenuExample();
        BRoleMenuExample.Criteria criteria = tRoleMenuExample.createCriteria();
        criteria.andRoleIdEqualTo(tRoleMenus.get(0).getRoleId());
        tRoleMenuMapper.deleteByExample(tRoleMenuExample);

        tRoleMenus.parallelStream().forEach(tRoleMenu -> {
            if (!StringUtils.isEmpty(tRoleMenu.getMenuCode())) {
                tRoleMenu.setId(UUIDUtils.getUUID());
                tRoleMenuMapper.insert(tRoleMenu);
            }
        });
        return tRoleMenus;
    }

    @Override
    public int delMenus(List<String> menuKeyList) {
        menuKeyList.parallelStream().forEach(key -> tMenuInfoMapper.deleteByPrimaryKey(key));
        return menuKeyList.size();
    }

    @Override
    public int delRoles(List<String> roleKeyList) {
        roleKeyList.parallelStream().forEach(key -> tRoleInfoMapper.deleteByPrimaryKey(key));
        return roleKeyList.size();
    }

    @Override
    public List<String> getMenuCodeByRoleId(String roleId) {
        if (StringUtils.isEmpty(roleId))
            return new ArrayList<>();
        BRoleMenuExample tRoleMenuExample = new BRoleMenuExample();
        BRoleMenuExample.Criteria criteria = tRoleMenuExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<BRoleMenu> list = tRoleMenuMapper.selectByExample(tRoleMenuExample);
        if (CollectionUtils.isEmpty(list))
            return new ArrayList<>();
        return list.stream().map(BRoleMenu::getMenuCode).collect(Collectors.toList());
    }
}
