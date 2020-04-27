package com.mumu.mmmaterialdesign.md;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

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
public class DrawerLayoutActivity extends AppCompatActivity {

    @BindView(R.id.abc_8)
    ActionBarCommon abc8;
    @BindView(R.id.btn_center_drawer1)
    Button btnCenterDrawer1;
    @BindView(R.id.btn_center_drawer2)
    Button btnCenterDrawer2;
    @BindView(R.id.btn_left_drawer)
    Button btnLeftDrawer;
    @BindView(R.id.btn_right_drawer)
    Button btnRightDrawer;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        ButterKnife.bind(this);

        abc8.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.btn_center_drawer1, R.id.btn_center_drawer2, R.id.btn_left_drawer, R.id.btn_right_drawer})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_center_drawer1:
                //打开左边菜单
                drawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.btn_center_drawer2:
                //打开右边菜单
                drawerLayout.openDrawer(Gravity.RIGHT);
                break;
            case R.id.btn_left_drawer:
                //关闭左边菜单
                drawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.btn_right_drawer:
                //关闭右边菜单
                drawerLayout.closeDrawer(Gravity.RIGHT);
                break;
        }
    }
}
