package com.demoapp.user.demoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.demoapp.user.demoapp.dialog.FingerPrintDialog;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
    implements FingerPrintDialog.FingerPrintListener {

    ImageButton radioButtonOne;
    ImageButton radioButtonTwo;
    ImageButton radioButtonThree;
    ImageButton radioButtonFour;
    ImageButton radioButtonFive;
    ImageButton radioButtonSix;

    TextView buttonOne;
    TextView buttonTwo;
    TextView buttonThree;
    TextView buttonFour;
    TextView buttonFive;
    TextView buttonSix;
    TextView buttonSeven;
    TextView buttonEight;
    TextView buttonNine;
    TextView buttonZero;

    ImageButton buttonFingerPrint;
    ImageButton buttonBackspace;

    TextView buttonCall;

    String password = "123456";
    char[] checkPassword = {'x', 'x', 'x', 'x', 'x', 'x'};


    int currentPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioButtonOne = (ImageButton) findViewById(R.id.radioButtonOne);
        radioButtonTwo = (ImageButton) findViewById(R.id.radioButtonTwo);
        radioButtonThree = (ImageButton) findViewById(R.id.radioButtonThree);
        radioButtonFour = (ImageButton) findViewById(R.id.radioButtonFour);
        radioButtonFive = (ImageButton) findViewById(R.id.radioButtonFive);
        radioButtonSix = (ImageButton) findViewById(R.id.radioButtonSix);

        buttonOne = (TextView) findViewById(R.id.buttonOne);
        buttonTwo = (TextView) findViewById(R.id.buttonTwo);
        buttonThree = (TextView) findViewById(R.id.buttonThree);
        buttonFour = (TextView) findViewById(R.id.buttonFour);
        buttonFive = (TextView) findViewById(R.id.buttonFive);
        buttonSix = (TextView) findViewById(R.id.buttonSix);
        buttonSeven = (TextView) findViewById(R.id.buttonSeven);
        buttonEight = (TextView) findViewById(R.id.buttonEight);
        buttonNine = (TextView) findViewById(R.id.buttonNine);
        buttonZero = (TextView) findViewById(R.id.buttonZero);

        buttonFingerPrint = (ImageButton) findViewById(R.id.buttonFingerPrint);
        buttonBackspace = (ImageButton) findViewById(R.id.buttonBackspace);

        View.OnClickListener buttonPasswordClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(currentPosition < 6) {
                    setPasswordChar(((TextView) v).getText().charAt(0));
                    if(currentPosition == 5 && new String(checkPassword).equals(password)) {
                        login();
                    }
                    currentPosition++;
                }


                Log.e("my_log_pass", password);
                Log.e("my_log_check", Arrays.toString(checkPassword));
                Log.e("my_log_tr", String.valueOf(Arrays.toString(checkPassword).equals(password)));
            }
        };

        buttonOne.setOnClickListener(buttonPasswordClickListener);
        buttonTwo.setOnClickListener(buttonPasswordClickListener);
        buttonThree.setOnClickListener(buttonPasswordClickListener);
        buttonFour.setOnClickListener(buttonPasswordClickListener);
        buttonFive.setOnClickListener(buttonPasswordClickListener);
        buttonSix.setOnClickListener(buttonPasswordClickListener);
        buttonSeven.setOnClickListener(buttonPasswordClickListener);
        buttonEight.setOnClickListener(buttonPasswordClickListener);
        buttonNine.setOnClickListener(buttonPasswordClickListener);
        buttonZero.setOnClickListener(buttonPasswordClickListener);

        buttonBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPosition > 0) {
                    currentPosition--;
                    unsetPasswordChar();
                }
            }
        });

        buttonFingerPrint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Manage.showFingerPrintDialog(MainActivity.this);
            }
        });

    }

    void setPasswordChar(char c) {

        Log.e("my_log", String.valueOf(c));
        Log.e("my_log", String.valueOf(currentPosition));

        Toast.makeText(MainActivity.this, String.valueOf(c), Toast.LENGTH_SHORT).show();

        switch (currentPosition) {
            case 0:
                radioButtonOne.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 1:
                radioButtonTwo.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 2:
                radioButtonThree.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 3:
                radioButtonFour.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 4:
                radioButtonFive.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 5:
                radioButtonSix.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
        }
        checkPassword[currentPosition] = c;
    }

    void unsetPasswordChar() {
        switch (currentPosition) {
            case 0:
                radioButtonOne.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 1:
                radioButtonTwo.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 2:
                radioButtonThree.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 3:
                radioButtonFour.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 4:
                radioButtonFive.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 5:
                radioButtonSix.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
        }
        checkPassword[currentPosition] = 'x';
    }

    @Override
    public void login() {
        Intent intent = new Intent(MainActivity.this, CameraActivity.class);
        startActivity(intent);
        finish();
    }

}
