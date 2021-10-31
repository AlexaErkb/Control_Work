package com.example.controlwork;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    ImageView progress, cat;
    TextView result_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        progress = findViewById(R.id.progress_bar);
        cat = findViewById(R.id.cat);
        result_info = findViewById(R.id.result_info);
        Bundle arguments = getIntent().getExtras();
        Integer Result = Integer.valueOf(arguments.get("result").toString());
        if (Result == 0) {
            cat.setImageResource(R.drawable.cat_excellent);
            progress.setImageResource(R.drawable.progressexcellent);
            result_info.setText("Введенные значения соответствуют отсутствию переутомления");
        } else if (Result == 1) {
            cat.setImageResource(R.drawable.cat_good);
            progress.setImageResource(R.drawable.progressgood);
            result_info.setText("Введенные значения соответствуют небольшому переутомлению. Рекомендуется снижение нагрузки");
        } else {
            cat.setImageResource(R.drawable.cat_not_bad);
            progress.setImageResource(R.drawable.not_bad);
            result_info.setText("Введенные значения соответствуют высокому уровню переутомления. Рекомендуется снижение нагрузки или отпуск");
        }
    }
}