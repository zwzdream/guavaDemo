package com.guava.annotion;

/**
 * @author WH1707008
 * @date 2018/8/14 19:54
 * Description:  鉴权人
 * 定义一个鉴权人接口，定义一个常量和一个鉴权方法
 */
public interface Identifier {
    /**
     * 无权限访问时的礼貌语
     */
    String REFUSE_WORD="你无权限访问";
    /**
     * 鉴权
     */
    boolean identify();
}
