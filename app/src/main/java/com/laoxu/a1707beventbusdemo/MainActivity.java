package com.laoxu.a1707beventbusdemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.laoxu.a1707beventbusdemo.entity.MainEntity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn1);
        EventBus.getDefault().register(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
//                intent.putExtra("name","kson");
//                startActivity(intent);

                MainEntity mainEntity = new MainEntity();
                mainEntity.name = "kson";
//                EventBus.getDefault().post(mainEntity);
                EventBus.getDefault().postSticky(mainEntity);
                startActivity(new Intent(MainActivity.this,Main2Activity.class));

            }
        });
    }


    @Subscribe
    public void getMain2(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }
}
