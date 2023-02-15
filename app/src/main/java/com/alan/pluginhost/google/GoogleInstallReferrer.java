package com.alan.pluginhost.google;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.alan.pluginhost.HostApp;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GoogleInstallReferrer {
    private static InstallReferrerClient referrerClient;

    public static void installReferrer(Context context) {
        try {
            referrerClient = InstallReferrerClient.newBuilder(context).build();
            referrerClient.startConnection(new InstallReferrerStateListener() {
                @Override
                public void onInstallReferrerSetupFinished(int responseCode) {
                    switch (responseCode) {
                        case InstallReferrerClient.InstallReferrerResponse.OK:
                            // Connection established.
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            ReferrerDetails response = null;
                            try {
                                response = referrerClient.getInstallReferrer();
                                String referrer = response.getInstallReferrer();
                                long referrerClickTime = response.getReferrerClickTimestampSeconds();
                                long appInstallTime = response.getInstallBeginTimestampSeconds();
                                boolean instantExperienceLaunched = response.getGooglePlayInstantParam();

                                HostApp.mReferrer.setReferrer(referrer);
                                HostApp.mReferrer.setAppInstallTime(sdf.format(new Date(appInstallTime)));
                                HostApp.mReferrer.setGooglePlayInstant(instantExperienceLaunched);

                                Log.e("xujm", "referrer---->" + HostApp.mReferrer.toString());
                                Log.d("referrer", "referrer------------>" + referrer);

                                Intent customIntent = new Intent();
                                customIntent.setAction("com.rupee.park.action.AFRECEIVER");
                                customIntent.putExtra(HostApp.BR_ACTION, HostApp.ACTION_RF);
                                customIntent.putExtra(HostApp.KEY_REFERRER, referrer);
                                customIntent.putExtra(HostApp.KEY_APPINSTALLTIME, sdf.format(new Date(appInstallTime)));
                                customIntent.putExtra(HostApp.KEY_INSTANTEXPERIENCELAUNCHED, instantExperienceLaunched);
                                context.sendBroadcast(customIntent);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                            referrerClient.endConnection();

                            break;
                        case InstallReferrerClient.InstallReferrerResponse.FEATURE_NOT_SUPPORTED:
                            // API not available on the current Play Store app.
                            HostApp.mReferrer.setReferrer("-1");
                            break;
                        case InstallReferrerClient.InstallReferrerResponse.SERVICE_UNAVAILABLE:
                            // Connection couldn't be established.
                            HostApp.mReferrer.setReferrer("-1");
                            break;
                    }
                }

                @Override
                public void onInstallReferrerServiceDisconnected() {
                    // Try to restart the connection on the next request to
                    // Google Play by calling the startConnection() method.
                }
            });
        } catch (Exception e) {
            HostApp.mReferrer.setReferrer("-1");
        }
    }
}
