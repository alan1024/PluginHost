package com.alan.pluginhost.google;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
//        LogCat.d("From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        Map<String, String> data = remoteMessage.getData();
        if (data.size() > 0) {
//            LogCat.d("Message data payload: " + remoteMessage.getData());
//            String jump = data.get("jump");
//            String order_id = data.get("order_id");
//            String platform_id = data.get("platform_id");
//
//            if (TextUtils.equals(jump, "1")) {
//                if (AppManager.currentActivity() != null) {
//                    OrderDetailActivity.startActivity(AppManager.currentActivity(), OrderDetailActivity.BACK2MAIN, order_id);
//                } else {
//                    OrderDetailActivity.startActivity_(BaseApp.getApp(), order_id);
//                }
//
//            } else if (TextUtils.equals(jump, "2")) {
//                if (AppManager.currentActivity() != null) {
//                    MainActivity.startActivity(AppManager.currentActivity(), "0");
//                } else {
//                    MainActivity.startActivity_(BaseApp.getApp(), "0");
//                }
//            } else if (TextUtils.equals(jump, "3")) {
//                if (AppManager.currentActivity() != null) {
//                    ConfirmLoanActivity.startActivity(AppManager.currentActivity(), platform_id);
//                } else {
//                    ConfirmLoanActivity.startActivity_(AppManager.currentActivity(), platform_id);
//                }
//            } else if (TextUtils.equals(jump, "4")) {
//                if (AppManager.currentActivity() != null) {
//                    MainActivity.startActivity(AppManager.currentActivity(), "0", 1);
//                } else {
//                    MainActivity.startActivity_(BaseApp.getApp(), "0", 1);
//                }
//            } else if (TextUtils.equals(jump, "5")) {
//                if (AppManager.currentActivity() != null) {
//                    AuthBankCardInfoActivity.startActivity(AppManager.currentActivity(),
//                            AuthBankCardInfoActivity.NO_GO_NEXT_AUTH, AuthBankCardInfoActivity.BACK2LAST, "");
//                } else {
//                    AuthBankCardInfoActivity.startActivity_(BaseApp.getApp(),
//                            AuthBankCardInfoActivity.NO_GO_NEXT_AUTH, AuthBankCardInfoActivity.BACK2LAST, "");
//                }
//            }

        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
//            LogCat.d("Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }
}
