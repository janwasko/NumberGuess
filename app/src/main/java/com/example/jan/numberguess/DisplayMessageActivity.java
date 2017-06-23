package com.example.jan.numberguess;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int counter = intent.getIntExtra(MainActivity.EXTRA_COUNTER, 0);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("GRAULACJE! Udało Ci się odganąć prawidłową liczbę jaką było: " + message);

        TextView counterView = (TextView) findViewById(R.id.counterView);
        counterView.setText("Ilość prób: " + Integer.toString(counter));
    }
}
