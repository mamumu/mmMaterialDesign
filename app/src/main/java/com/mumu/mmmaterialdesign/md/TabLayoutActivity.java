package com.mumu.mmmaterialdesign.md;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mumu.mmmaterialdesign.R;
import com.mumu.mmmaterialdesign.adapter.TabLayoutFragmentAdapter;
import com.mumu.mmmaterialdesign.framelayout.TablayoutFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import per.goweii.actionbarex.common.ActionBarCommon;
import per.goweii.actionbarex.common.OnActionBarChildClickListener;

/**
 * @author : zlf
 * date    : 2020/4/24
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class TabLayoutActivity extends AppCompatActivity {

    @BindView(R.id.abc_7)
    ActionBarCommon abc7;
    @BindView(R.id.tb)
    TabLayout tb;
    @BindView(R.id.vp_tab)
    ViewPager vpTab;

    List<String> mTitles = new ArrayList<>();
    List<String> mTitleNumbers = new ArrayList<>();
    List<String> mLabels = new ArrayList<>();
    List<TablayoutFragment> mFragments = new ArrayList<>();

    private int position = 0;//当前tab的位置

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);

        abc7.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {
        mTitleNumbers.clear();
        mTitles.clear();
        mLabels.clear();
        mFragments.clear();
        for (int i = 0; i < 10; i++) {
            mTitleNumbers.add(String.valueOf(100+i));
            mTitles.add("花好月圆" + "\n");
            mLabels.add(String.valueOf(i));
            mFragments.add(TablayoutFragment.newInstance(mLabels.get(i), mTitles.get(i)));
        }
        TabLayoutFragmentAdapter tabLayoutFragmentAdapter = new TabLayoutFragmentAdapter(getSupportFragmentManager(), mFragments, mTitles);
        vpTab.setAdapter(tabLayoutFragmentAdapter);
        tb.setupWithViewPager(vpTab);
        tb.getTabAt(position).select();
        tb.getTabAt(position).setText(mTitles.get(position) + mTitleNumbers.get(position));

        //tab监听
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.setText(mTitles.get(tab.getPosition()) + mTitleNumbers.get(tab.getPosition()));
                if (tab.getPosition() != 0) {
                    position = tab.getPosition();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.setText(mTitles.get(tab.getPosition()));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
