package com.example.busapp

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.fragment.app.ListFragment
import java.util.ArrayList
import kotlin.collections.contains as contains1

class FindBluetoothDevicesActivity : AppCompatActivity() {

    private val listItems = ArrayList<BluetoothDevice>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_bluetooth_devices)

        var siema = intent.getStringExtra("siema")

        var text2: TextView = findViewById<TextView>(R.id.bluetoothElement1)

        var bluetoothDevices = FindBluetoothDevices();


        if (siema == "POLACZONO") {
            text2.setText("POLOCZONO")
        } else {
            text2.setText("NIEPOLOCZONO")
        }

    }

}