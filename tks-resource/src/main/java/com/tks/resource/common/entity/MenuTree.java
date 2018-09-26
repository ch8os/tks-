package com.tks.resource.common.entity;

import java.util.List;

import lombok.Data;

/**
 * @ Purpose:
 * @Package Name: com.dpm.resource.common
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@Data
public class MenuTree extends BMenuInfo {
    private List<MenuTree> children;
}
