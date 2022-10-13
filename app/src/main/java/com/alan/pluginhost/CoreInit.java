package com.alan.pluginhost;

/**
 * 描述：
 *
 * @author Cuizhen
 * @date 2019/4/27
 */
public class CoreInit {


    private static class Holder {
        private static final CoreInit INSTANCE = new CoreInit();
    }

    private CoreInit() {
    }

    public static CoreInit getInstance() {
        return Holder.INSTANCE;
    }


}
