package com.mumu.mmmaterialdesign.md;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.circularreveal.cardview.CircularRevealCardView;
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
public class CardViewActivity extends AppCompatActivity {

    @BindView(R.id.abc_5)
    ActionBarCommon abc5;
    @BindView(R.id.card_view1)
    CardView cardView1;
    @BindView(R.id.card_view2)
    CircularRevealCardView cardView2;
    @BindView(R.id.card_view3)
    CardView cardView3;
    @BindView(R.id.card_view4)
    CardView cardView4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        ButterKnife.bind(this);

        abc5.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.card_view1, R.id.card_view2, R.id.card_view3, R.id.card_view4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.card_view1:
                Toast.makeText(CardViewActivity.this, "花好月圆（CardView）", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_view2:
                Toast.makeText(CardViewActivity.this, "花好月圆（CircularRevealCardView）", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_view3:
                Toast.makeText(CardViewActivity.this, "复杂布局的CardView", Toast.LENGTH_SHORT).show();
                break;
            case R.id.card_view4:
                Toast.makeText(CardViewActivity.this, "带图片的CardView", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
