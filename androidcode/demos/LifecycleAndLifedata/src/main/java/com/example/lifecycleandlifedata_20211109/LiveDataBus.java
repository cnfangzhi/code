package com.example.lifecycleandlifedata_20211109;

import androidx.lifecycle.MutableLiveData;

import java.util.HashMap;
import java.util.Map;

/**
 * 这条总线用于把任何类中的数据直接传递到activity或是fragment上
 */
public class LiveDataBus {

    //存放订阅者
    private Map<String, MutableLiveData<Object>> bus;

    private static LiveDataBus liveDataBus = new LiveDataBus();

    private LiveDataBus() {
        bus = new HashMap<>();
    }

    public static LiveDataBus getInstance() {
        return liveDataBus;
    }


    //注册订阅者，（存入map）
    public synchronized <T> MutableLiveData<T> with(String key,Class<T> type,boolean sticky){
        if(!bus.containsKey(key)){
            if(sticky){
                bus.put(key, new MutableLiveData<Object>());
            }else {
                bus.put(key, new NonStickyMutableLiveData<Object>());
            }
        }
        return (MutableLiveData<T>) bus.get(key);
    }




}

