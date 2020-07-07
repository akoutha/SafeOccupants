package com.example.safeoccupants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.*;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private TextView occupancy;
    private Button incrementButton;
    private Button decrementButton;
    private int occupantAmount = 0;
    private int maxOcc;
    private TextView occupancyAmountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(200);
        seekBar.setProgress(30);
        occupancy = (TextView) findViewById(R.id.textView);
        occupancyAmountText = (TextView) findViewById(R.id.currentOccupant);
        maxOcc = seekBar.getProgress();
        occupancy.setText("Occupancy Set at "+seekBar.getProgress());
       // occupancy.setText(seekBar.getProgress());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                occupancy.setText("Occupancy Set at " + progress);
                maxOcc = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        incrementButton = (Button) findViewById(R.id.incrementButton);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                occupantAmount++;
                if(occupantAmount > maxOcc){
                    occupantAmount--;
                    Snackbar.make(v, "You are over max occupancy", Snackbar.LENGTH_LONG).show();
                }
                else{
                    occupancyAmountText.setText(occupantAmount+"");
                }
            }
        });
        decrementButton = findViewById(R.id.decrementButton);
        decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                occupantAmount--;
                if(occupantAmount < 0 ){
                    occupantAmount++;
                    //Snackbar.make(v, "Replace with your own action", Snackbar.LENGTH_LONG).show();
                }
                else{
                    occupancyAmountText.setText(occupantAmount+"");
                }
            }
        });


    }
}