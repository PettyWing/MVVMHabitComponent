package com.xyc.moudle_material.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyc.moudle_material.R;

/**
 * Created by xieyusheng on 2019/1/2.
 */
@Route(path = "/material/main")
public class MaterialActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_activity_main);
    }
}
