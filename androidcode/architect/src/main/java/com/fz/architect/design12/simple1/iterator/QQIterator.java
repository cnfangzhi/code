package com.fz.architect.design12.simple1.iterator;


import com.fz.architect.design12.simple1.UserInfo;

import java.util.List;

/**
 * Created by fz on 2017/10/22.
 * 微信的具体的迭代器
 */

public class QQIterator implements Iterator<UserInfo>{
    List<UserInfo> userInfos;
    int index = 0;

    public QQIterator(List<UserInfo> userInfos){
        this.userInfos = userInfos;
    }

    @Override
    public UserInfo next() {
        return userInfos.get(index++);
    }

    @Override
    public boolean hasNext() {
        return index<userInfos.size();
    }
}
