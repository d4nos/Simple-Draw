package com.draw.master.tool.pro;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public abstract class ProBaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onLayout());
        this.initViews(savedInstanceState);
    }


    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract int onLayout();
}
