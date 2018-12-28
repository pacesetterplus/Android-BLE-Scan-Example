package com.example.joelwasserman.androidbletutorial;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ScanViewModel extends AndroidViewModel {

    private BleScan scanner;


    public ScanViewModel(@NonNull Application application) {
        super(application);
        scanner = new BleScan(application.getApplicationContext());
    }


    MutableLiveData<List<String>> getAllFipyDevices() {
        return scanner.getDevices();
    }

    public void startScanning(){
        scanner.startScanning();
    }

    public void stopScanning(){
        scanner.stopScanning();
    }

}
