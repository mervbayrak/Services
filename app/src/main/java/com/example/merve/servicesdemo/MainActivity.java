package com.example.merve.servicesdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Boolean isStarted=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intent=new Intent(this,MyService.class);
    }

    public void startMyService(View view) {
        if(isStarted)
        {
            stopService(intent);
        }
        else
        {
            startService(intent);
        }

        isStarted=!isStarted;
    }

    public void startMyIntentService(View view) {
        Intent intent=new Intent(this,MyIntentService.class);
        intent.setAction(MyIntentService.ACTION_DOWNLOAD);
        intent.putExtra(MyIntentService.EXTRA_PARAM1,"https://muhendisadayiblog.files.wordpress.com/2017/05/android_800_thumb800.jpg");
        startService(intent);

        Intent intentUpload=new Intent(this,MyIntentService.class);
        intent.setAction(MyIntentService.ACTION_UPLOAD);
        intent.putExtra(MyIntentService.EXTRA_PARAM1,"www.google.com/mylocation/");
        startService(intentUpload);

    }
}
