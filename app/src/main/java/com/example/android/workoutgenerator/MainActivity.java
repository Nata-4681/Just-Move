package com.example.android.workoutgenerator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int equipCount = 1;
    int movementCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner equipSpinner1 = (Spinner) findViewById(R.id.equipment_spinner1);
        Spinner equipSpinner2 = (Spinner) findViewById(R.id.equipment_spinner2);
        Spinner equipSpinner3 = (Spinner) findViewById(R.id.equipment_spinner3);
        ArrayAdapter equipAdapter = ArrayAdapter.createFromResource(this,
                R.array.equipment_array, R.layout.spinner_item);

        equipAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        equipSpinner1.setAdapter(equipAdapter);
        equipSpinner2.setAdapter(equipAdapter);
        equipSpinner3.setAdapter(equipAdapter);

        Spinner moveSpinner1 = (Spinner) findViewById(R.id.movements_spinner1);
        Spinner moveSpinner2 = (Spinner) findViewById(R.id.movements_spinner2);
        Spinner moveSpinner3 = (Spinner) findViewById(R.id.movements_spinner3);
        ArrayAdapter moveAdapter = ArrayAdapter.createFromResource(this,
                R.array.movement_array, R.layout.spinner_item);

        moveAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        moveSpinner1.setAdapter(moveAdapter);
        moveSpinner2.setAdapter(moveAdapter);
        moveSpinner3.setAdapter(moveAdapter);



    }


    public void submit(View view){
        Intent intent = new Intent(this, WorkoutActivity.class);
        Spinner equipSpinner1 = (Spinner) findViewById(R.id.equipment_spinner1);
        Spinner movementSpinner1 = (Spinner) findViewById(R.id.movements_spinner1);
        String equipSelection1 = equipSpinner1.getSelectedItem().toString();
        String movementSelection1 = movementSpinner1.getSelectedItem().toString();
        intent.putExtra("EquipSelection1", equipSelection1);
        intent.putExtra("MovementSelection1", movementSelection1);
        startActivity(intent);
        }


    public void addEquipment(View view){


        LinearLayout spinner2 = (LinearLayout) findViewById(R.id.equipment_layout2);
        LinearLayout spinner3 = (LinearLayout) findViewById(R.id.equipment_layout3);

        if (equipCount == 1){
            spinner2.setVisibility(View.VISIBLE);
            equipCount += 1;
        }
        else if (equipCount == 2){
            spinner3.setVisibility(View.VISIBLE);
            equipCount += 1;
        }

    }

    public void addMovement(View view){

        LinearLayout spinner2 = (LinearLayout) findViewById(R.id.movement_layout2);
        LinearLayout spinner3 = (LinearLayout) findViewById(R.id.movement_layout3);

        if (movementCount == 1){
            spinner2.setVisibility(View.VISIBLE);
            movementCount += 1;
        }
        else if (movementCount == 2){
            spinner3.setVisibility(View.VISIBLE);
            movementCount += 1;
        }

    }

    public void savedWorkouts(View view){
        Intent intent = new Intent(this, SavedActivity.class);
        startActivity(intent);

    }


}
