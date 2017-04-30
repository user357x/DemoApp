package com.demoapp.user.demoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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
                    currentPosition++;
                    setPasswordChar();
                }
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
                    unsetPasswordChar();
                    currentPosition--;
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

    void setPasswordChar() {
        switch (currentPosition) {
            case 1:
                radioButtonOne.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 2:
                radioButtonTwo.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 3:
                radioButtonThree.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 4:
                radioButtonFour.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 5:
                radioButtonFive.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
            case 6:
                radioButtonSix.setImageResource(R.drawable.ic_radio_button_checked_black_24dp);
                break;
        }
    }

    void unsetPasswordChar() {
        switch (currentPosition) {
            case 1:
                radioButtonOne.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 2:
                radioButtonTwo.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 3:
                radioButtonThree.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 4:
                radioButtonFour.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 5:
                radioButtonFive.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
            case 6:
                radioButtonSix.setImageResource(R.drawable.ic_radio_button_unchecked_red_24dp);
                break;
        }
    }

}
