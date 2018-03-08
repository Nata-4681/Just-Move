package com.example.android.workoutgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SavedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);


        final ArrayList<Workout> workouts = new ArrayList<>();
        workouts.add(new Workout("5 rounds for time of:\n" + "Run 400 meters\n" + "15 thrusters", "Men: 95 lb.\nWomen: 65 lb.", "FT"));
        workouts.add(new Workout("15 min Thrusters AMRAP:\n10 Burpees\n10 Sit ups\10 Hand Release Push ups", "AMRAP"));
        workouts.add(new Workout (" 3 rounds for time of:\n" + "50 GHD sit-ups\n" + "25 Dumbbell curls and Thrusters", "FT"));
        workouts.add(new Workout ("3 Rounds For Time:\nRun 800m\n50 Air Squats", "FT"));

        WorkoutAdapter adapter = new WorkoutAdapter(this, workouts);

        GridView gridView = (GridView) findViewById(R.id.saved_list);


        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //Toast.makeText(WorkoutActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SavedActivity.this, DetailsActivity.class);
                Workout detailWorkout = workouts.get(position);
                intent.putExtra("Workout", detailWorkout);
                startActivity(intent);
            }
        });
    }


}
