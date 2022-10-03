package com.dowei.lesson2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView tv = findViewById(R.id.TextView1);
//        Button bt = findViewById(R.id.button);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("你好呀，世界！");
//            }
//        });
        SharedPreferences sp = getSharedPreferences("username",MODE_PRIVATE);
//        SharedPreferences.Editor edit = sp.edit();
//        edit.putString("username","Johnny");
//        edit.commit();

        String string = sp.getString("user1", "DIO");
        System.out.println(string);
    }

    public void bt_click(View view) {
//        TextView tv = findViewById(R.id.TextView1);
//        tv.setText("你好呀，世界！");
//        Intent intent = new Intent(this,MainActivity2.class);
//        startActivity(intent);
        //隐式
//        Intent intent = new Intent();
//        intent.setAction("DoWei.com");
//        startActivity(intent);
        //打开相机
//        Intent intent = new Intent();
//        intent.setAction("android.media.action.IMAGE_CAPTURE");
//        startActivity(intent);

        //传递参数
//        Intent intent = new Intent(this,MainActivity2.class);
//        intent.putExtra("username","dowei");
//        intent.putExtra("password","123");
//        startActivity(intent);




    }
}