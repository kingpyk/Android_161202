package com.example.a403.a201344036watch;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {

    Chronometer chm1;
    CalendarView cdv1;
    Button btn1, btn2;
    RadioButton rbtn1, rbtn2;
    TimePicker tp1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chm1 = (Chronometer) findViewById(R.id.chm1);
        cdv1 = (CalendarView) findViewById(R.id.calendarView);
        btn1 = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        rbtn1 = (RadioButton) findViewById(R.id.rbtn1);
        rbtn2 = (RadioButton) findViewById(R.id.rbtn2);
        tp1 = (TimePicker) findViewById(R.id.timePicker);
        tv1 = (TextView) findViewById(R.id.tv1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chm1.setBase(SystemClock.elapsedRealtime());
                chm1.start();
                chm1.setTextColor(Color.RED);//실수로 2과정에 3까지 넣었습니다
            }
        });
        rbtn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cdv1.setVisibility(View.VISIBLE);
                    tp1.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    }