package com.mumu.mmmaterialdesign.md;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mumu.mmmaterialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import per.goweii.actionbarex.common.ActionBarCommon;
import per.goweii.actionbarex.common.OnActionBarChildClickListener;

/**
 * @author : zlf
 * date    : 2020/4/24
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class FloatingActionButtonActivity extends AppCompatActivity {

    @BindView(R.id.abc_4)
    ActionBarCommon abc4;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.efab)
    ExtendedFloatingActionButton efab;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_action_button);
        ButterKnife.bind(this);

        abc4.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.fab, R.id.efab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fab:

                break;
            case R.id.efab:
                if(efab.isExtended()){
                    efab.shrink();
                }else {
                    efab.extend();
                }
                break;
        }
    }
}
