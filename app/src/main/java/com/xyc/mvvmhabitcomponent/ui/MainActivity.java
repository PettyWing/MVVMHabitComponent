package com.xyc.mvvmhabitcomponent.ui;

import android.os.Bundle;

import com.xyc.mvvmhabitcomponent.BR;
import com.xyc.mvvmhabitcomponent.R;
import com.xyc.mvvmhabitcomponent.databinding.ActivityMainBinding;

import me.goldze.mvvmhabit.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public int initContentView(Bundle bundle) {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
