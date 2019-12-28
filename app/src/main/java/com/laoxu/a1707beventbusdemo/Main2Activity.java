package com.laoxu.a1707beventbusdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.laoxu.a1707beventbusdemo.entity.MainEntity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    private TextView tv;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.name);
        btn2 = findViewById(R.id.btn2);
//        String name = getIntent().getExtras().getString("")
//        tv.setText(name);
        EventBus.getDefault().register(this);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               EventBus.getDefault().post("aaaaa");
               finish();
            }
        });
    }

    /**
     *
     * @param s eventbus传输的类型,订阅并接收的过程
     */
    @Subscribe(sticky = true,threadMode = ThreadMode.ASYNC)
    public void getName(MainEntity mainEntity){

        Log.e("xxxxt",Thread.currentThread().getName());

        tv.setText(mainEntity.name);

    }
}
