package com.fz.architect.design11.simple2;

import com.fz.architect.design11.simple2.iterator.Iterator;
import com.fz.architect.design11.simple2.iterator.QQIterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fz on 2017/10/22.
 * QQ用户系统 - 列表存储
 */
public class QQUserSystem implements Aggregate<UserInfo>{
    private List<UserInfo> userInfos;

    public QQUserSystem(){
        userInfos = new ArrayList<>();
        userInfos.add(new UserInfo("Darren","240336124","001","男"));
        userInfos.add(new UserInfo("夕决","240336124","002","男"));
        userInfos.add(new UserInfo("yjy239","240336124","003","男"));
    }

    @Override
    public Iterator<UserInfo> iterator() {
        return new QQIterator(userInfos);
    }
}
