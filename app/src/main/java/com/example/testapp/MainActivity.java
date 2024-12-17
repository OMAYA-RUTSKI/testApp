package com.example.testapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView temperatureText;
    private Button btnIncrease, btnDecrease, btnOnOff;
    private int currentTemperature = 25;
    private boolean isOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temperatureText = findViewById(R.id.temperatureText);
        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);
        btnOnOff = findViewById(R.id.btnOnOff);

        btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn) {
                    currentTemperature++;
                    updateTemperatureDisplay();
                } else {
                    Toast.makeText(MainActivity.this, "The device is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOn) {
                    currentTemperature--;
                    updateTemperatureDisplay();
                } else {
                    Toast.makeText(MainActivity.this, "The device is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnOnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOn = !isOn;  // Toggle ON/OFF state
                if (isOn) {
                    btnOnOff.setText("ON");
                    Toast.makeText(MainActivity.this, "The device is ON", Toast.LENGTH_SHORT).show();
                } else {
                    btnOnOff.setText("OFF");
                    Toast.makeText(MainActivity.this, "The device is OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void updateTemperatureDisplay() {
        temperatureText.setText(currentTemperature + "°C");
    }
}