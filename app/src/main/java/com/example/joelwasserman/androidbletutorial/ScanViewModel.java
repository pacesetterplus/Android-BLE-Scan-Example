package com.example.joelwasserman.androidbletutorial;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class ScanViewModel extends AndroidViewModel {

    private BleScan scanner;


    public ScanViewModel(@NonNull Application application) {
        super(application);
        scanner = new BleScan(application.getApplicationContext());
    }
}
