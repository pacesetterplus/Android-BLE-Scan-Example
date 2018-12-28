package com.example.joelwasserman.androidbletutorial;

import android.app.Activity;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.MutableLiveData;

public class BleScan {

    private BluetoothLeScanner btScanner;
    private TextView peripheralTextView;
    private MutableLiveData<List<String>> liveData;

    public MutableLiveData<List<String>> getDevices() {
        return liveData;
    }

    private  List<String> devices;


    public BleScan(Context context) {
        this.btScanner = ((BluetoothManager)context.getSystemService(Context.BLUETOOTH_SERVICE)).getAdapter().getBluetoothLeScanner();
        //peripheralTextView = ((Activity)context).findViewById(R.id.PeripheralTextView);
        devices = new ArrayList<>();
        liveData = new MutableLiveData<>();

    }



    // Device scan callback.
    private ScanCallback leScanCallback = new ScanCallback() {
        @Override
        public void onScanResult(int callbackType, ScanResult result) {
            if(result != null){
                StringBuilder builder = new StringBuilder();
                builder.append("Device Name: " + result.getDevice().getName() + " Address: " + result.getDevice().getAddress());
                devices.add(builder.toString());
                System.out.println(builder.toString());
                Log.d("Yusuf",builder.toString());

                liveData.postValue(devices);
            }
/*            peripheralTextView.append("Device Name: " + result.getDevice().getName() + " rssi: " + result.getRssi() + "\n");

            // auto scroll for text view
            final int scrollAmount = peripheralTextView.getLayout().getLineTop(peripheralTextView.getLineCount()) - peripheralTextView.getHeight();
            // if there is no need to scroll, scrollAmount will be <=0
            if (scrollAmount > 0)
                peripheralTextView.scrollTo(0, scrollAmount);*/
        }
    };


    public void startScanning() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                btScanner.startScan(leScanCallback);
            }
        });
    }

    public void stopScanning() {

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                btScanner.stopScan(leScanCallback);
            }
        });
    }
}
