package com.example.lsm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class uic extends AppCompatActivity implements View.OnClickListener {
private Button chal1;
private Button chazd1;
private Button api1;
private Button lz;//两点查询
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uic);
        findViewById(R.id.chaxl).setOnClickListener(this);
        findViewById(R.id.chazd).setOnClickListener(this);
        findViewById(R.id.chaxl).setOnClickListener(this);
        findViewById(R.id.apis).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.apis:
                Intent intent=new Intent(this,apis.class);
                startActivity(intent);

                break;
        }

    }
}