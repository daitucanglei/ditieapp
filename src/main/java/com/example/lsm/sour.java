package com.example.lsm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.amap.api.services.help.Inputtips;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;

import java.util.ArrayList;
import java.util.List;

public class sour extends AppCompatActivity implements TextWatcher, Inputtips.InputtipsListener {
private EditText editText;
private RecyclerView recyclerView;
private RvAdapter rvAdapter;
private   Inputtips inputTips;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sour);

        editText=findViewById(R.id.edit_query);
        editText.addTextChangedListener(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        inputTips = new Inputtips(this, (InputtipsQuery)null);
        inputTips.setInputtipsListener(this);
    }
    @Override
    public void onGetInputtips(List<Tip> list, int i) {

    }
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
InputtipsQuery inputtipsQuery=new InputtipsQuery(String.valueOf(charSequence),"0731");
inputtipsQuery.setCityLimit(true);
inputTips.setQuery(inputtipsQuery);
inputTips.requestInputtipsAsyn();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }


}