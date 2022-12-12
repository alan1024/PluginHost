package com.alan.pluginhost;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.qihoo360.replugin.RePlugin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (RePlugin.isPluginInstalled("loan")) {
            RePlugin.startActivity(MainActivity.this, RePlugin.createIntent("loan", "com.rocket.loan.uang.ui.beat.BeatActivity"));
            finish();
        } else {
            Toast.makeText(MainActivity.this, "You must install loan first!", Toast.LENGTH_SHORT).show();
        }

    }
}