package com.tks.sn.common.utils;

import java.util.UUID;

public class SNUtils {

	/**
     * 功能：获取UUID并去除“-”
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString();
        return uuid.replaceAll("\\-", "");
    }
}
