package com.alan.pluginhost.rx.bus;


public interface RxIBus {


    /**
     * Register an event target
     *
     * @param target
     * @return
     */
    boolean register(Object target);

    /**
     * UnRegister the event target
     *
     * @param target
     * @return
     */
    boolean unregister(Object target);

    /**
     * Post event
     *
     * @param event
     */
    void post(Object event);

}
