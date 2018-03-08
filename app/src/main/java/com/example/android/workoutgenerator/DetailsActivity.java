package com.example.android.workoutgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i = getIntent();
        Workout detailWorkout = (Workout)i.getSerializableExtra("Workout");

        TextView desc = (TextView) findViewById(R.id.fulldescription);
        desc.setText(detailWorkout.getWorkoutDesc());

        TextView rx = (TextView) findViewById(R.id.rx);
        rx.setText(detailWorkout.getWorkoutRX());


    }

    public void addNewWorkout(View view){


    }
}
