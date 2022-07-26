package com.fz.architect.demo01.simple3;

/**
 * Email 514905121@qq.com
 * Created by fz on 2017/3/12.
 * Version 1.0
 * Description:
 */
public class PreferencesHttpCache{
    /**
     * 获取数据
     */
    public String getCacheResultJson(String finalUrl) {
        return (String) PreferencesUtil.getInstance().getParam(finalUrl, "");
    }

    /**
     * 缓存数据
     */
    public long cacheData(String finalUrl, String resultJson) {
        PreferencesUtil.getInstance().saveParam(finalUrl, resultJson);
        return 1;
    }
}
