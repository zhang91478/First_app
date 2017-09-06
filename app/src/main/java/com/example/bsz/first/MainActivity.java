package com.example.bsz.first;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    LayoutInflater inflater;
    String userId = "";
    String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //为主界面右面的按钮设置监听事件
        final Button button_right = (Button)findViewById(R.id.right_button);
        button_right.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {//点击响应事件
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.login, null);
                final EditText editText1= view.findViewById(R.id.user);
                final EditText editText2= view.findViewById(R.id.password);

                builder.setView(view).setTitle("登陆")
                .setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // 登陆按钮

                        userId = editText1.getText().toString();
                        password = editText2.getText().toString();

                        if(!userId.equals("123")) {
                            Toast.makeText(MainActivity.this, "账号错误", Toast.LENGTH_LONG).show();
                        }
                        else if(!password.equals("456")){
                            Toast.makeText(MainActivity.this, "密码错误"+password, Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this, "登陆成功", Toast.LENGTH_LONG).show();
                        }
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //退出按钮
                    }
                    });
                    builder.show();
                    }
        });
    }
}
