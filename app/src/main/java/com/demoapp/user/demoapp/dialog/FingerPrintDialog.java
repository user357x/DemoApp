package com.demoapp.user.demoapp.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.demoapp.user.demoapp.R;

/**
 * Created by user on 01.05.17.
 */

public class FingerPrintDialog extends DialogFragment {

    //String info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //info = getArguments().getString("info");
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout;
        getDialog().setTitle("Прикоснитесь к сенсору");
        layout = inflater.inflate(R.layout.dialog_finger_print, container, false);
        //((TextView) layout.findViewById(R.id.infoTextView)).setText(info);
        layout.findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dismiss();
            }
        });
        layout.findViewById(R.id.fingerPrint).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FingerPrintListener) getActivity()).login();
            }
        });
        return layout;
    }

    public interface FingerPrintListener {
        void login();
    }

}
