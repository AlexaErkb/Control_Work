package com.example.controlwork;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    ImageView cat;
    TextView result_info;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        cat = findViewById(R.id.cat);
        progressBar = findViewById(R.id.progress_bar);
        result_info = findViewById(R.id.result_info);
        Bundle arguments = getIntent().getExtras();
        Integer Result = Integer.valueOf(arguments.get("result").toString());
        progressBar.setProgress(Result);
        if (Result > 60) {
            cat.setImageResource(R.drawable.cat_excellent);
            result_info.setText("Введенные значения соответствуют отсутствию переутомления");
        } else if (Result >= 30) {
            cat.setImageResource(R.drawable.cat_good);
            result_info.setText("Введенные значения соответствуют небольшому переутомлению. Рекомендуется снижение нагрузки");
        } else {
            cat.setImageResource(R.drawable.cat_not_bad);
            result_info.setText("Введенные значения соответствуют высокому уровню переутомления. Рекомендуется снижение нагрузки или отпуск");
        }
    }
}