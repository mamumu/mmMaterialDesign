package com.mumu.mmmaterialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.mumu.mmmaterialdesign.md.BottomNavigationViewActivity;
import com.mumu.mmmaterialdesign.md.CardViewActivity;
import com.mumu.mmmaterialdesign.md.FloatingActionButtonActivity;
import com.mumu.mmmaterialdesign.md.SnackBarActivity;
import com.mumu.mmmaterialdesign.md.SwitchCompatActivity;
import com.mumu.mmmaterialdesign.md.TabLayoutActivity;
import com.mumu.mmmaterialdesign.md.TextInputLayoutActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;
    @BindView(R.id.btn5)
    Button btn5;
    @BindView(R.id.btn6)
    Button btn6;
    @BindView(R.id.btn7)
    Button btn7;
    @BindView(R.id.btn8)
    Button btn8;
    @BindView(R.id.btn9)
    Button btn9;
    @BindView(R.id.btn10)
    Button btn10;
    @BindView(R.id.btn11)
    Button btn11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9, R.id.btn10, R.id.btn11})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(MainActivity.this, TextInputLayoutActivity.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(MainActivity.this, SnackBarActivity.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this, SwitchCompatActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(MainActivity.this, FloatingActionButtonActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(MainActivity.this, CardViewActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(MainActivity.this, BottomNavigationViewActivity.class));
                break;
            case R.id.btn7:
                startActivity(new Intent(MainActivity.this, TabLayoutActivity.class));
                break;
            case R.id.btn8:
                break;
            case R.id.btn9:
                break;
            case R.id.btn10:
                break;
            case R.id.btn11:
                break;
        }
    }
}
