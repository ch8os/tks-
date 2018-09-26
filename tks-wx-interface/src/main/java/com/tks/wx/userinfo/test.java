package com.tks.wx.userinfo;

import com.tks.wx.common.utils.WxAPiUtils;

public class test {
    public static void main(String[] args) {
        String accessToken = WxAPiUtils.getAccessToken();
        System.out.println(accessToken);

    }
}
