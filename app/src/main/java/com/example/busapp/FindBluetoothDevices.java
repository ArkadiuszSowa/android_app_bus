package com.example.busapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class FindBluetoothDevices {

    public ArrayList<BluetoothDevice> listItems = new ArrayList<>();
    public BluetoothDevice espDevice;
    public String ESP_ADRESS = "E0:E2:E6:D1:08:0E";

    public void findBluetoothDevices(BluetoothAdapter bluetoothAdapter) {
        listItems.clear();
        Log.d("URZADZENIA", "findBluetoothDevices");
        if (bluetoothAdapter != null) {
            Log.d("URZADZENIA", "bluetoothAdapter != null");
            for (BluetoothDevice device : bluetoothAdapter.getBondedDevices())
                if (device.getType() != BluetoothDevice.DEVICE_TYPE_LE) {
                    listItems.add(device);
                    Log.d("URZADZENIA", device.toString());
                }
        }
        Collections.sort(listItems, FindBluetoothDevices::compareTo);

    }

    static int compareTo(BluetoothDevice a, BluetoothDevice b) {
        boolean aValid = a.getName() != null && !a.getName().isEmpty();
        boolean bValid = b.getName() != null && !b.getName().isEmpty();
        if (aValid && bValid) {
            int ret = a.getName().compareTo(b.getName());
            if (ret != 0) return ret;
            return a.getAddress().compareTo(b.getAddress());
        }
        if (aValid) return -1;
        if (bValid) return +1;
        return a.getAddress().compareTo(b.getAddress());
    }

    public void findESP() {

        for (int i = 0; i < listItems.size(); i++) {
            String listelement = listItems.get(i).getAddress();
            if (listelement == ESP_ADRESS) {
                espDevice = listItems.get(i);
                Log.d("znalezione", espDevice.toString());
            }
        }
    }
}
