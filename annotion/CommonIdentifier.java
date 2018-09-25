package com.guava.annotion;

/**
 * @author WH1707008
 * @date 2018/8/14 19:58
 * Description:  权限级别和鉴权方法之间紧耦合，这里定义一个enum，不分成两个类
 */
public enum CommonIdentifier implements Identifier {
    //权限级别
    Reader,Author,Admin;

    @Override
    public boolean identify() {
        return false;
    }
}
