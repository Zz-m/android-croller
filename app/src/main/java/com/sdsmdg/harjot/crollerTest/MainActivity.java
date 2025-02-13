package com.sdsmdg.harjot.crollerTest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

public class MainActivity extends AppCompatActivity {

    private Croller croller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        croller = findViewById(R.id.croller);
        SwitchCompat enableSwitch = findViewById(R.id.enableSwitch);

        enableSwitch.setChecked(croller.isEnabled());

//        croller.setIndicatorWidth(10);
//        croller.setBackCircleColor(Color.parseColor("#EDEDED"));
//        croller.setMainCircleColor(Color.WHITE);
//        croller.setMax(50);
//        croller.setStartOffset(45);
//        croller.setIsContinuous(false);
//        croller.setLabelColor(Color.BLACK);
//        croller.setProgressPrimaryColor(Color.parseColor("#0B3C49"));
//        croller.setIndicatorColor(Color.parseColor("#0B3C49"));
//        croller.setProgressSecondaryColor(Color.parseColor("#EEEEEE"));
//        croller.setProgressRadius(380);
//        croller.setBackCircleRadius(300);


        croller.setOnCrollerChangeListener(new OnCrollerChangeListener() {
            @Override
            public void onProgressChanged(Croller croller, int progress) {
//                Log.d(MainActivity.class.getName(), "Progress croller: " + progress );
            }

            @Override
            public void onStartTrackingTouch(Croller croller) {
                Toast.makeText(MainActivity.this, "Start", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(Croller croller) {
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
            }
        });

        croller.setOnValueChangedListener((v, fromUser) -> Log.d(MainActivity.class.getName(), "Progress: " + v + " fromUser:" + fromUser));

        enableSwitch.setOnCheckedChangeListener((compoundButton, b) -> croller.setEnabled(b));

    }
}
