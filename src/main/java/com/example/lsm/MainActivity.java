package com.example.lsm;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView zd;
    private EditText et_zd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_zd=findViewById(R.id.et_zd);
        zd=findViewById(R.id.zd);
        findViewById(R.id.chazda).setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String s = et_zd.getText().toString();
        switch (view.getId())
        {
            case R.id.chazda:
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        UserDao userDao = new UserDao(); String a=""; Looper.prepare();
                        try {
                            List<ditiepojo> liu = userDao.chazd(s);
                            for(ditiepojo u:liu)
                            {
                                a+="("+u.getXianlu()+")"+u.getZhandian()+" ";
                                System.out.println(a);
                            }
                            zd.setText(a);
                            Toast.makeText(MainActivity.this, "查询成功", Toast.LENGTH_SHORT).show();
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