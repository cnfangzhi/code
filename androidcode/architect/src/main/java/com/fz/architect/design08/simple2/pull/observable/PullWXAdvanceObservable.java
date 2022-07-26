package com.fz.architect.design08.simple2.pull.observable;

/**
 * Created by fz on 2017/10/14.
 * 微信公众号 - Android进阶之旅公众号
 */

public class PullWXAdvanceObservable extends PullWXPublicObservable {
    private String article;

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
        // 通知更新,推送给微信用户
        update(article);
    }
}
