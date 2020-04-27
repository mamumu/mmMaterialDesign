package com.mumu.mmmaterialdesign.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.mumu.mmmaterialdesign.framelayout.TablayoutFragment;

import java.util.List;

/**
 * @author : zlf
 * date    : 2020/3/9
 * github  : https://github.com/mamumu
 * blog    : https://www.jianshu.com/u/281e9668a5a6
 * desc    :
 */
public class TabLayoutFragmentAdapter extends FragmentStatePagerAdapter {
    private List<TablayoutFragment> mFragments;
    private List<String> mTitles;

    public TabLayoutFragmentAdapter(FragmentManager fm, List<TablayoutFragment> mFragments, List<String> mTitles) {
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }


}
