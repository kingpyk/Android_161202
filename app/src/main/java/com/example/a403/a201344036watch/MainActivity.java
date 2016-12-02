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
    String cdv,tp,date;

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
        cdv = "";
        tp = "";
        date = "";

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
        rbtn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    cdv1.setVisibility(View.INVISIBLE);
                    tp1.setVisibility(View.VISIBLE);
                }
            }
        });
        cdv1.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView cal_view, int year, int month, int day){
                cdv = year+"년"+month+"월"+day+"일";
            }
        });
        tp1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hour, int minute) {
            tp = hour+"시"+minute+"분";
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                date = cdv+tp;
                tv1.setText(date+"예약됨");
                chm1.stop();
                chm1.setTextColor(Color.BLUE);

            }
        });
    }
    }