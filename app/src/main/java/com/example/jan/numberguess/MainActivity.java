package com.example.jan.numberguess;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.jan.MESSAGE";

    public static final String EXTRA_COUNTER = "com.example.jan.NUMBER";

    private int random;

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        random = new Random().nextInt(101);
        counter = 0;
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        counter++;
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        int number;
        try {
            number = Integer.parseInt(message);
        } catch (NumberFormatException e) {
            showToast("Podaj poprawną liczbę!");
            return;
        }
        if (number != random) {
            if (number < random) {
                showToast("Za mało");
            } else {
                showToast("Za dużo");
            }
        } else {
            Intent intent = new Intent(this, DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            intent.putExtra(EXTRA_COUNTER, counter);
            startActivity(intent);
        }
    }

    private void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
