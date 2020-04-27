package com.mumu.mmmaterialdesign.md;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mumu.mmmaterialdesign.R;
import com.mumu.mmmaterialdesign.framelayout.BaseFragment;
import com.mumu.mmmaterialdesign.framelayout.FindFragment;
import com.mumu.mmmaterialdesign.framelayout.HomeFragment;
import com.mumu.mmmaterialdesign.framelayout.MineFragment;
import com.mumu.mmmaterialdesign.framelayout.RankFragment;
import com.trello.rxlifecycle3.components.support.RxFragment;

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
public class BottomNavigationViewActivity extends AppCompatActivity {

    @BindView(R.id.abc_6)
    ActionBarCommon abc6;
    @BindView(R.id.bnv)
    BottomNavigationView bnv;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;

    private HomeFragment mHomeFragment;
    private FindFragment mFindFragment;
    private RankFragment mRankFragment;
    private MineFragment mMineFragment;
    private BaseFragment mCurFragment = new BaseFragment();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_view);
        ButterKnife.bind(this);

        abc6.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {
        mHomeFragment = HomeFragment.instance();
        mFindFragment = FindFragment.instance();
        mRankFragment = RankFragment.instance();
        mMineFragment = MineFragment.instance();
        //默认首页
        changeFragment(mHomeFragment).commit();
        //监听BottomNavigationView的点击事件
        bnv.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener =new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.main_home:
                    changeFragment(mHomeFragment).commit();
                    return true;
                case R.id.main_find:
                    changeFragment(mFindFragment).commit();
                    return true;
                case R.id.main_rank:
                    changeFragment(mRankFragment).commit();
                    return true;
                case R.id.main_mine:
                    changeFragment(mMineFragment).commit();
                    return true;
                default:
                    break;
            }
            return false;
        }
    };

    /**
     *  切换fragment
     * @param targetFragment 当前fragment
     * @return
     */
    public FragmentTransaction changeFragment(BaseFragment targetFragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!targetFragment.isAdded()) {
            if (mCurFragment != null) {
                transaction.hide(mCurFragment);
            }
            transaction.add(R.id.framelayout, targetFragment, targetFragment.getClass().getName());
        } else {
            transaction.hide(mCurFragment)
                    .show(targetFragment);
        }
        mCurFragment = targetFragment;
        return transaction;
    }
}
