package com.fz.architect.design11.simple2.iterator;

import com.fz.architect.design11.simple2.UserInfo;

/**
 * Created by fz on 2017/10/22.
 * 微信的具体的迭代器
 */

public class WXIterator implements Iterator<UserInfo>{
    UserInfo[] userInfos;
    int index = 0;

    public WXIterator(UserInfo[] userInfos){
        this.userInfos = userInfos;
    }

    @Override
    public UserInfo next() {
        return userInfos[index++];
    }

    @Override
    public boolean hasNext() {
        return index<userInfos.length;
    }
}
