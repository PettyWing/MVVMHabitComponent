package com.xyc.moudle_material.ui;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.xyc.moudle_material.R;
import com.xyc.moudle_material.databinding.MaterialActivityMainBinding;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

/**
 * Created by xieyusheng on 2019/1/2.
 */
@Route(path = "/material/main")
public class MaterialActivity extends BaseActivity<MaterialActivityMainBinding,MaterialViewModel> {

    @Override
    public int initContentView(Bundle bundle) {
        return R.layout.material_activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
