package com.example.lsm;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class lxcha extends AppCompatActivity implements View.OnClickListener {
    private TextView xl;
    private EditText et_xl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lxcha);
        et_xl=findViewById(R.id.et_xl);
        xl= findViewById(R.id.xl);
        findViewById(R.id.chaxla).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String s = et_xl.getText().toString();
        switch (view.getId())
        {
            case R.id.chaxla:
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        UserDao userDao = new UserDao(); String a="";
                        try {
                            List<ditiepojo> liu = userDao.chaxl(s);
                            for(ditiepojo u:liu)
                            {
                                a+="("+u.getXianlu()+")"+u.getZhandian()+" ";
                                System.out.println(a);
                            }Looper.prepare();
                            xl.setText(a);
                            Toast.makeText(lxcha.this, "查询成功", Toast.LENGTH_SHORT).show();
                            Looper.loop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
        }
    }
}