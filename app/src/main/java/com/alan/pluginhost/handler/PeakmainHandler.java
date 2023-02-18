package com.alan.pluginhost.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import org.json.JSONObject;

import java.util.concurrent.ConcurrentHashMap;

public class PeakmainHandler extends Handler {
    private long mStartTime = System.currentTimeMillis();
    private ConcurrentHashMap<Message, String> sMsgDetail = new ConcurrentHashMap<>();

    public PeakmainHandler() {
        super(Looper.myLooper(), null);
    }

    public PeakmainHandler(Callback callback) {
        super(Looper.myLooper(), callback);
    }

    public PeakmainHandler(Looper looper, Callback callback) {
        super(looper, callback);
    }

    public PeakmainHandler(Looper looper) {
        super(looper);
    }

    @Override
    public boolean sendMessageAtTime(Message msg, long uptimeMillis) {
        boolean send = super.sendMessageAtTime(msg, uptimeMillis);
        if (send) {
            sMsgDetail.put(msg, Log.getStackTraceString(new Throwable()).replace("java.lang.Throwable", ""));
        }
        return send;
    }

    @Override
    public void dispatchMessage(Message msg) {
        mStartTime = System.currentTimeMillis();
        super.dispatchMessage(msg);

        if (sMsgDetail.containsKey(msg)
                && Looper.myLooper() == Looper.getMainLooper()) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("Msg_Cost", System.currentTimeMillis() - mStartTime);
                jsonObject.put("MsgTrace", msg.getTarget() + " " + sMsgDetail.get(msg));

                Log.i("PeakmainHandler", "MsgDetail " + jsonObject.toString());
                sMsgDetail.remove(msg);
            } catch (Exception e) {
            }
        }
    }

}
