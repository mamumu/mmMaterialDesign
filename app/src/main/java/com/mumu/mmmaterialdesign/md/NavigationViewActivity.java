package com.mumu.mmmaterialdesign.md;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
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
public class NavigationViewActivity extends AppCompatActivity {

    @BindView(R.id.abc_9)
    ActionBarCommon abc9;
    @BindView(R.id.btn_center_navigation)
    Button btnCenterNavigation;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    @BindView(R.id.dl_navigation)
    DrawerLayout dlNavigation;

    private MenuItem menuItem1;
    private MenuItem menuItem2_1;
    private MenuItem menuItem2_2;
    private MenuItem menuItem2_3;
    private MenuItem menuItem3;
    private MenuItem menuItem4;
    private TextView tvHeader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_view);
        ButterKnife.bind(this);

        abc9.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {
        menuItem1 = navigationView.getMenu().findItem(R.id.menu_item1);
        menuItem2_1 = navigationView.getMenu().findItem(R.id.menu_item2_1);
        menuItem2_2 = navigationView.getMenu().findItem(R.id.menu_item2_2);
        menuItem2_3 = navigationView.getMenu().findItem(R.id.menu_item2_3);
        menuItem3 = navigationView.getMenu().findItem(R.id.menu_item3);
        menuItem4 = navigationView.getMenu().findItem(R.id.menu_item4);
        tvHeader=navigationView.getHeaderView(0).findViewById(R.id.navigation_header);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_item1:
                        Toast.makeText(NavigationViewActivity.this, "点击菜单1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item2_1:
                        Toast.makeText(NavigationViewActivity.this, "点击菜单2-1", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item2_2:
                        Toast.makeText(NavigationViewActivity.this, "点击菜单2-2", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item2_3:
                        Toast.makeText(NavigationViewActivity.this, "点击菜单2-3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item3:
                        Toast.makeText(NavigationViewActivity.this, "点击菜单3", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_item4:
                        Toast.makeText(NavigationViewActivity.this, "点击菜单4", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });

        tvHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NavigationViewActivity.this, "点击头部", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @OnClick({R.id.btn_center_navigation, R.id.navigation_exit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_center_navigation:
                dlNavigation.openDrawer(Gravity.LEFT);
                break;
            case R.id.navigation_exit:
                Toast.makeText(NavigationViewActivity.this, "退出登录", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
