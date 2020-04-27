package com.mumu.mmmaterialdesign.framelayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.mumu.mmmaterialdesign.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RankFragment extends BaseFragment {
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rank, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

    }
    public static final RankFragment instance() {
        return EventFragmentHolder.INSTANCE;
    }

    public static class EventFragmentHolder {
        private static final RankFragment INSTANCE = new RankFragment();
    }
}
