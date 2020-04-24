package com.mumu.mmmaterialdesign.md;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
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
public class TextInputLayoutActivity extends AppCompatActivity {

    @BindView(R.id.abc_1)
    ActionBarCommon abc1;
    @BindView(R.id.tiet1)
    TextInputEditText tiet1;
    @BindView(R.id.til1)
    TextInputLayout til1;
    @BindView(R.id.tiet2)
    TextInputEditText tiet2;
    @BindView(R.id.til2)
    TextInputLayout til2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
        ButterKnife.bind(this);

        abc1.setOnLeftIconClickListener(new OnActionBarChildClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initView();
    }

    private void initView() {
        tiet1.addTextChangedListener(new MTextWatcher(R.id.tiet1));
        tiet2.addTextChangedListener(new MTextWatcher(R.id.tiet2));
    }

    /**
     * 设置文字状态改变
     */
    class MTextWatcher implements TextWatcher {

        private int id;

        public MTextWatcher(int id) {
            this.id = id;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (id) {
                case R.id.tiet1:
                    if (s.toString().trim().length() > til1.getCounterMaxLength()) {
                        til1.setError("超出最大输入字数！！！");
                    }else {
                        til1.setErrorEnabled(false);
                    }
                    break;
                case R.id.tiet2:
                    if (s.toString().trim().length() > til2.getCounterMaxLength()) {
                        til2.setError("超出最大输入字数！！！");
                    }else {
                        til2.setErrorEnabled(false);
                    }
                    break;
            }
        }
    }
}
