package com.example.controlwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {
    int selectedYear = 2001;
    int selectedMonth = 8;
    int selectedDayOfMonth = 17;
    Spinner day, selectMonth, selectYear, selectSex;
    Integer[] Day = new Integer[31];
    Integer [] Year = new Integer[121];
    String [] Month = new String[] {
            "январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"
    };
    String [] Sex = new String [] {
            "М", "Ж"
    };
    EditText first_pulse, second_pulse;
    ArrayAdapter<Integer> days, years;
    ArrayAdapter<String> months, sexes;
    Button done;
    public int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add();
        first_pulse = findViewById(R.id.first_pulse);
        second_pulse = findViewById(R.id.second_pulse);
        day = findViewById(R.id.day);
        selectMonth = findViewById(R.id.month);
        selectYear = findViewById(R.id.year);
        selectSex = findViewById(R.id.sexes);
        done = findViewById(R.id.done);
        days = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Day);
        day.setAdapter(days);
        years = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Year);
        selectYear.setAdapter(years);
        months = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Month);
        selectMonth.setAdapter(months);
        sexes = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Sex);
        sexes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        selectSex.setAdapter(sexes);
        day.setClickable(false);
        selectYear.setClickable(false);
        selectMonth.setClickable(false);
        day.setOnTouchListener(this);
        selectYear.setOnTouchListener(this);
        selectMonth.setOnTouchListener(this);
        done.setOnClickListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        day.setSelection(dayOfMonth-1);
                        selectYear.setSelection(year-1901);
                        selectMonth.setSelection(monthOfYear);
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        dateSetListener, selectedYear, selectedMonth, selectedDayOfMonth);
                Date minDate = new Date(1901, 0, 1);
                Date minAndroid = new Date(1970, 0, 1);
                long minMillisAndroid = minAndroid.getTime();
                long minDateMillis = minDate.getTime();
                long min = minDateMillis - minMillisAndroid;
                datePickerDialog.getDatePicker().setMinDate(min);
                datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                datePickerDialog.show();
        }
        return false;
    }
    @Override
    public void onClick(View v) {
        if ((first_pulse.getText().toString().trim().length()==0) || (second_pulse.getText().toString().trim().length()==0)) {

        } else {
            result = (int) (Math.random()*3);
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("result", String.valueOf(result));
            startActivity(intent);
        }
    }
    public void add() {
        for (int i = 1; i <= Day.length; i++) {
            Day[i-1] = i;
        }
        for (int i = 1; i <= Year.length; i++) {
            Year[i-1] = 1900 + i;
        }
    }

}