package com.fz.architect.demo06.simple2;

import androidx.annotation.NonNull;

/**
 * Created by fz on 2017/12/2.
 * 观察者
 */
public interface Observer<T> {
    void onSubscribe();
    void onNext(@NonNull T item);
    void onError(@NonNull Throwable e);
    void onComplete();
}
