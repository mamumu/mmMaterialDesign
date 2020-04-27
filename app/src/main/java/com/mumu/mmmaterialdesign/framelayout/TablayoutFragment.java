package com.mumu.mmmaterialdesign.framelayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.mumu.mmmaterialdesign.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TablayoutFragment extends BaseFragment {
    Unbinder unbinder;
    @BindView(R.id.tv_fragment_tab)
    TextView tvFragmentTab;

    private String mName;
    private String mLabel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_layout, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
        tvFragmentTab.setText(mName + mLabel);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    public static TablayoutFragment newInstance(String label, String name) {
        TablayoutFragment tablayoutFragment = new TablayoutFragment();
        Bundle bundle = new Bundle();
        bundle.putString("label", label);
        bundle.putString("name", name);
        tablayoutFragment.setArguments(bundle);
        return tablayoutFragment;
    }

    private void getData() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mLabel = bundle.getString("label");
            mName = bundle.getString("name");
        }
    }
}
