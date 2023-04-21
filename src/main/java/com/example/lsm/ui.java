package com.example.lsm;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class ui extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        findViewById(R.id.chaxl).setOnClickListener(this);
        findViewById(R.id.chazd).setOnClickListener(this);
        findViewById(R.id.chald).setOnClickListener(this);
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
            case R.id.chaxl:
                Intent intent1=new Intent(this,lxcha.class);
                startActivity(intent1);
                break;
            case R.id.chazd:
                Intent intent2=new Intent(this,MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.chald:
                Intent intent3=new Intent(this,ld.class);
                startActivity(intent3);
                break;
        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}