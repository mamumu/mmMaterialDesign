package com.mumu.mmmaterialdesign.md;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;
import com.mumu.mmmaterialdesign.MainActivity;
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
public class SnackBarActivity extends AppCompatActivity {

    @BindView(R.id.abc_2)
    ActionBarCommon abc2;
    @BindView(R.id.snackbar_btn1)
    Button snackbarBtn1;
    @BindView(R.id.snackbar_btn2)
    Button snackbarBtn2;
    @BindView(R.id.snackbar_ll)
    LinearLayout snackbarLl;

    private Snackbar snackbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snack_bar);
        ButterKnife.bind(this);

        abc2.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {

    }

    @OnClick({R.id.snackbar_btn1, R.id.snackbar_btn2, R.id.snackbar_btn3, R.id.snackbar_btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.snackbar_btn1:
                initSnackBar1();
                break;
            case R.id.snackbar_btn2:
                initSnackBar2();
                break;
            case R.id.snackbar_btn3:
                initSnackBar3();
                break;
            case R.id.snackbar_btn4:
                initSnackBar4();
                break;
        }
    }

    /**
     * Snackbar.LENGTH_INDEFINITE 不消失显示，除非手动取消
     * Snackbar.LENGTH_SHORT 短时间显示
     * Snackbar.LENGTH_LONG 长时间显示
     */
    private void initSnackBar1() {
        snackbar = Snackbar.make(snackbarLl, "这是一个系统的SnackBar", Snackbar.LENGTH_SHORT);
        snackbar.show();
    }

    private void initSnackBar2() {
        snackbar = Snackbar.make(snackbarLl, "这是一个系统的（带按钮）SnackBar", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("好看吗？", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snackbar.dismiss();
                Toast.makeText(SnackBarActivity.this, "不好看", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.show();
    }

    private void initSnackBar3() {
        snackbar = Snackbar.make(snackbarLl, "这是一个系统的（带回调）SnackBar", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("好看吗？", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackBarActivity.this, "不好看", Toast.LENGTH_SHORT).show();
            }
        });
        snackbar.addCallback(new Snackbar.Callback() {
            @Override
            public void onShown(Snackbar sb) {
                super.onShown(sb);
                Log.i("mmm", "SnackBar显示");
            }

            @Override
            public void onDismissed(Snackbar transientBottomBar, int event) {
                super.onDismissed(transientBottomBar, event);
                Log.i("mmm", "SnackBar隐藏");
            }
        });
        snackbar.show();
    }

    private void initSnackBar4() {
        snackbar = Snackbar.make(snackbarLl, "这是一个自定义的SnackBar", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("好看吗？", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackBarActivity.this, "好看", Toast.LENGTH_SHORT).show();
            }
        });
        final Snackbar.SnackbarLayout snackbarView = (Snackbar.SnackbarLayout) snackbar.getView();
        //设置SnackBar背景与透明度
        snackbarView.setBackgroundResource(R.color.colorPrimary);
        snackbarView.setAlpha((float) 0.9);
        //设置SnackBar的padding
        snackbarView.setPadding(20, 0, 20, 10);

        //设置Action的字体颜色与大小
        final Button snackbar_action = (Button) snackbarView.findViewById(R.id.snackbar_action);
        snackbar_action.setTextColor(Color.WHITE);
        snackbar_action.setTextSize(15);

        //这是Text的文字颜色与大小
        final TextView snackbar_text = (TextView) snackbarView.findViewById(R.id.snackbar_text);
        snackbar_text.setTextColor(Color.WHITE);

        //设置左边图片
        Drawable drawable = getResources().getDrawable(R.mipmap.icon1);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        snackbar_text.setCompoundDrawables(drawable, null, null, null);
        //增加文字和图标的距离
        snackbar_text.setCompoundDrawablePadding(20);
        snackbar_text.setGravity(Gravity.CENTER);
        snackbar.show();
    }
}
