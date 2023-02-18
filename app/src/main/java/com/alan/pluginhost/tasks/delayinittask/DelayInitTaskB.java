package com.alan.pluginhost.tasks.delayinittask;

public class DelayInitTaskB extends MainTask {

    @Override
    public void run() {
        // 模拟一些操作
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
