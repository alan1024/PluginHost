package com.alan.pluginhost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alan.pluginhost.model.bean.remote.CoBill;
import com.alan.pluginhost.utils.ActivityManagerUtils;
import com.alan.pluginhost.utils.BillUtils;
import com.alan.pluginhost.utils.DateUtils;
import com.alan.pluginhost.utils.DimenUtils;
import com.alan.pluginhost.utils.FormatUtils;
import com.alan.pluginhost.utils.GlideCacheUtil;
import com.alan.pluginhost.utils.HttpUtils;
import com.alan.pluginhost.utils.ImageUtils;
import com.alan.pluginhost.utils.PieChartUtils;
import com.alan.pluginhost.utils.ProgressUtils;
import com.alan.pluginhost.utils.RegexUtils;
import com.alan.pluginhost.utils.SharedPUtils;
import com.alan.pluginhost.utils.SnackbarUtils;
import com.alan.pluginhost.utils.StringUtils;
import com.alan.pluginhost.utils.ThemeManager;
import com.alan.pluginhost.utils.ToastUtils;
import com.alan.pluginhost.utils.UiUtils;

import java.util.Date;

public class MainActivity8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ActivityManagerUtils.hasActivity();
        BillUtils.toBBill(new CoBill());
        DateUtils.date2Str(new Date());
        DimenUtils.dp2px(20);
        FormatUtils.moneyFormat("20");
        GlideCacheUtil.getInstance().clearImageAllCache(this);
        HttpUtils.request("");
        ImageUtils.getDrawable("");
        PieChartUtils.initPieChart();
        ProgressUtils.dismiss();
        RegexUtils.checkPassword("222222");
        SharedPUtils.getCurrentTheme(this);
        SnackbarUtils.show(this,"");
        StringUtils.checkEmail("");
        ThemeManager.getInstance().init(this);
        ToastUtils.show(this,"abc");
        UiUtils.getContext();
    }
}