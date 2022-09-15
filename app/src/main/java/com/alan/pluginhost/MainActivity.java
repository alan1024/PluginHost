package com.alan.pluginhost;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.qihoo360.replugin.RePlugin;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (RePlugin.isPluginInstalled("loan")) {
            RePlugin.startActivity(MainActivity.this, RePlugin.createIntent("loan", "cわㄚ.ぷゾ.ㅂㅞㆫ.ゼナシ"));
//                    RePlugin.startActivity(MainActivity.this, RePlugin.createIntent("loan", "cわㄚ.ぷゾ.ㅂㅞㆫ.ㆧほにㆹ"));
            finish();
        } else {
            Toast.makeText(MainActivity.this, "You must install demo3 first!", Toast.LENGTH_SHORT).show();
        }



//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }
}