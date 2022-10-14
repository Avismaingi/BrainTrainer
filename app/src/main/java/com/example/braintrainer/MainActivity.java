package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int correct = 0;
    int total = 0;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int result;

    public void select(View view) {
        String t = (String) view.getTag();
        Log.i("Tag!", t);
        int option = Integer.parseInt(t);
        TextView r = (TextView) findViewById(R.id.result);
        if (answers.get(option) == result) {
            correct++;
            total++;
            r.setText("Correct");

        } else {
            total++;
            r.setText("Wrong");
        }

        answers.clear();

        TextView solved = (TextView) findViewById(R.id.solved);
        solved.setText(correct + "/" + total);

        int min = 1, max = 100;
        int num1 = (int) (Math.random() * (max - min + 1) + min);
        int num2 = (int) (Math.random() * (max - min + 1) + min);
        TextView question = (TextView) findViewById(R.id.question);
        question.setText(num1 + "+" + num2);
        Log.i("Num1 : ", String.valueOf(num1));
        Log.i("Num2 : ", String.valueOf(num2));
        result = num1 + num2;
        Log.i("Result : ", String.valueOf(result));


        Button o1 = (Button) findViewById(R.id.button1);
        Button o2 = (Button) findViewById(R.id.button2);
        Button o3 = (Button) findViewById(R.id.button3);
        Button o4 = (Button) findViewById(R.id.button4);

        int index = (int) (Math.random() * (3 + 1) + 0);
        Log.i("Index : ", String.valueOf(index));

        max = 200;
        for (int i = 0; i < 4; i++) {

            if (i != index) {
                answers.add((int) (Math.random() * (max - min + 1) + min));
            } else {
                answers.add(result);
            }
        }

        o1.setText(String.valueOf(answers.get(0)));
        o2.setText(String.valueOf(answers.get(1)));
        o3.setText(String.valueOf(answers.get(2)));
        o4.setText(String.valueOf(answers.get(3)));
    }


    public void restart(View view) {

        TextView time = (TextView) findViewById(R.id.time);
        TextView question = (TextView) findViewById(R.id.question);
        TextView solved = (TextView) findViewById(R.id.solved);
        Button retry = (Button) findViewById(R.id.retry);
        Button o1 = (Button) findViewById(R.id.button1);
        Button o2 = (Button) findViewById(R.id.button2);
        Button o3 = (Button) findViewById(R.id.button3);
        Button o4 = (Button) findViewById(R.id.button4);
        Button go = (Button) findViewById(R.id.button);
        TextView r = (TextView) findViewById(R.id.result);
        time.setVisibility(View.VISIBLE);
        question.setVisibility(View.VISIBLE);
        solved.setVisibility(View.VISIBLE);
        retry.setVisibility(View.INVISIBLE);
        o1.setVisibility(View.VISIBLE);
        o2.setVisibility(View.VISIBLE);
        o3.setVisibility(View.VISIBLE);
        o4.setVisibility(View.VISIBLE);
        r.setVisibility(View.VISIBLE);
        go.setVisibility(View.INVISIBLE);
        o1.setEnabled(true);
        o2.setEnabled(true);
        o3.setEnabled(true);
        o4.setEnabled(true);

        new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                Log.i("Time", String.valueOf(l / 1000));
                time.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {
                Log.i("Time", "Finished");
                r.setText("Result");
                correct = 0;
                total = 0;
                o1.setEnabled(false);
                o2.setEnabled(false);
                o3.setEnabled(false);
                o4.setEnabled(false);
                retry.setVisibility(View.VISIBLE);
            }
        }.start();

        solved.setText(correct + "/" + total);

        int min = 1, max = 100;
        int num1 = (int) (Math.random() * (max - min + 1) + min);
        int num2 = (int) (Math.random() * (max - min + 1) + min);
        question.setText(num1 + "+" + num2);
        result = num1 + num2;


        int index = (int) (Math.random() * (3 + 1) + 0);

        max = 200;
        for (int i = 0; i < 4; i++) {

            if (i != index) {
                answers.add((int) (Math.random() * (max - min + 1) + min));
            } else {
                answers.add(result);
            }
        }


        o1.setText(String.valueOf(answers.get(0)));
        o2.setText(String.valueOf(answers.get(1)));
        o3.setText(String.valueOf(answers.get(2)));
        o4.setText(String.valueOf(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView time = (TextView) findViewById(R.id.time);
        TextView question = (TextView) findViewById(R.id.question);
        TextView result = (TextView) findViewById(R.id.solved);
        Button retry = (Button) findViewById(R.id.retry);
        Button o1 = (Button) findViewById(R.id.button1);
        Button o2 = (Button) findViewById(R.id.button2);
        Button o3 = (Button) findViewById(R.id.button3);
        Button o4 = (Button) findViewById(R.id.button4);
        Button go = (Button) findViewById(R.id.button);
        TextView r = (TextView) findViewById(R.id.result);
        time.setVisibility(View.INVISIBLE);
        question.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        o1.setVisibility(View.INVISIBLE);
        o2.setVisibility(View.INVISIBLE);
        o3.setVisibility(View.INVISIBLE);
        o4.setVisibility(View.INVISIBLE);
        r.setVisibility(View.INVISIBLE);
        go.setVisibility(View.VISIBLE);
    }
}