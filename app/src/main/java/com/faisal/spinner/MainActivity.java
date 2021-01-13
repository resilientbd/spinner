package com.faisal.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.faisal.base.BaseActivity;
import com.faisal.spinner.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseActivity {
    ActivityMainBinding mBinding;
    ArrayAdapter<String> arrayAdapter;
    private String item;
    @Override
    public int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void startUI() {
        mBinding=(ActivityMainBinding) getViewDataBinding();
        List<String> gender = Arrays.asList(getResources().getStringArray(R.array.title_item));
        arrayAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,gender);
        mBinding.Spinner.setAdapter(arrayAdapter);
        mBinding.Spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                    item = parent.getItemAtPosition(position).toString();
                    mBinding.Spinner.setPrompt(item);
                    mBinding.buttonSpinner.setOnClickListener(View->{
                        mBinding.textView.setText(item);
                    });
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }

        });
    }
}