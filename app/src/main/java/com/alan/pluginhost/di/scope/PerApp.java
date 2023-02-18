package com.alan.pluginhost.di.scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

/**
 * @author ：Peakmain
 * version ：1.0
 * createTime ：2018/10/19 0019 下午 6:51
 * mail : 2726449200@qq.com
 * describe ：
 */
@Scope
@Documented
@Retention(RUNTIME)

public @interface PerApp {
}
