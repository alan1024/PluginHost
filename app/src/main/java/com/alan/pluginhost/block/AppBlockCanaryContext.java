package com.alan.pluginhost.block;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class AppBlockCanaryContext {


    public String provideQualifier() {
        return "unknown";
    }


    public String provideUid() {
        return "uid";
    }


    public String provideNetworkType() {
        return "unknown";
    }


    public int provideMonitorDuration() {
        return -1;
    }


    public int provideBlockThreshold() {
        return 500;
    }


    public int provideDumpInterval() {
        return provideBlockThreshold();
    }


    public String providePath() {
        return "/blockcanary/";
    }


    public boolean displayNotification() {
        return true;
    }


    public boolean zip(File[] src, File dest) {
        return false;
    }


    public void upload(File zippedFile) {
        throw new UnsupportedOperationException();
    }


    public List<String> concernPackages() {
        return null;
    }


    public boolean filterNonConcernStack() {
        return false;
    }


    public List<String> provideWhiteList() {
        LinkedList<String> whiteList = new LinkedList<>();
        whiteList.add("org.chromium");
        return whiteList;
    }


    public boolean deleteFilesInWhiteList() {
        return true;
    }


}
