package com.example.lsm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ld extends AppCompatActivity implements View.OnClickListener {
    private TextView zx;
    private EditText et_qi;
    private EditText et_zhd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ld);
        zx = findViewById(R.id.zx);
        et_qi=findViewById(R.id.et_qi);
       et_zhd=findViewById(R.id.et_zhd);
       findViewById(R.id.zxl).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String s = et_qi.getText().toString();
        String s1 = et_zhd.getText().toString();
        switch (view.getId())
        {
            case R.id.zxl:
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        UserDao userDao = new UserDao(); String a="";
                        try {
                            List<String> liu = userDao.ld(s,s1);
                            for(String u:liu)
                            {
                              a+=u+" ";
                              System.out.println(a);
                            }
                            Looper.prepare();
                            zx.setText(a);
                            Toast.makeText(ld.this, "查询成功", Toast.LENGTH_SHORT).show();
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