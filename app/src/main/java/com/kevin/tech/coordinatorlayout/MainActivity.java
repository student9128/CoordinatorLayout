package com.kevin.tech.coordinatorlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kevin.tech.coordinatorlayout.activity.FirstActivity;
import com.kevin.tech.coordinatorlayout.activity.SecondActivity;
import com.kevin.tech.coordinatorlayout.activity.ThirdActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnFirst, mBtnSecond, mBtnThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnFirst = (Button) findViewById(R.id.btn_first);
        mBtnSecond = (Button) findViewById(R.id.btn_second);
        mBtnThird = (Button) findViewById(R.id.btn_third);
        mBtnFirst.setOnClickListener(this);
        mBtnSecond.setOnClickListener(this);
        mBtnThird.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_first:
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
                break;
            case R.id.btn_second:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
            case R.id.btn_third:
                startActivity(new Intent(MainActivity.this, ThirdActivity.class));
                break;
            default:
                break;
        }
    }
}
