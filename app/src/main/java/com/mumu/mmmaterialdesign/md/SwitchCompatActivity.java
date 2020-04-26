package com.mumu.mmmaterialdesign.md;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.mumu.mmmaterialdesign.R;

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
public class SwitchCompatActivity extends AppCompatActivity {

    @BindView(R.id.abc_3)
    ActionBarCommon abc3;
    @BindView(R.id.switch_compat1)
    SwitchCompat switchCompat1;
    @BindView(R.id.switch_compat2)
    SwitchCompat switchCompat2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch_compat);
        ButterKnife.bind(this);

        abc3.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {
        //设置字体颜色
        switchCompat1.setTextOn(Html.fromHtml("<font color=#FFFFFF>" +"on" + "</font>"));
        switchCompat1.setTextOff(Html.fromHtml("<font color=#FFFFFF>" +"off" + "</font>"));

        //增加switchCompat的事件监听
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    //表示选中状态
                    Toast.makeText(SwitchCompatActivity.this, "选中状态", Toast.LENGTH_SHORT).show();
                }else {
                    //表示非选中状态
                    Toast.makeText(SwitchCompatActivity.this, "非选中状态", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
