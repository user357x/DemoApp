package com.demoapp.user.demoapp;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;

import com.demoapp.user.demoapp.dialog.FingerPrintDialog;

/**
 * Created by user on 01.05.17.
 */

public class Manage {
    public static void showFingerPrintDialog(AppCompatActivity appCompatActivity) {
        FragmentTransaction fragmentTransaction = appCompatActivity.getFragmentManager().beginTransaction();
        Fragment prev = appCompatActivity.getFragmentManager().findFragmentByTag("fingerPrintDialog");
        if (prev != null) fragmentTransaction.remove(prev);
        fragmentTransaction.addToBackStack(null);
        android.app.DialogFragment newFragment = new FingerPrintDialog();
        Bundle args = new Bundle();
        newFragment.show(fragmentTransaction, "fingerPrintDialog");
    }
}
