package com.example.busapp

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener  {

    var siema = ""
    var bluetoothDevices = FindBluetoothDevices();
    var ba: BluetoothAdapter? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.application_start)

        if (applicationContext.getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_BLUETOOTH)
        ) ba = BluetoothAdapter.getDefaultAdapter()

        Log.d("ba" , ba.toString())

        bluetoothDevices.findBluetoothDevices(ba);
    }

    override fun onBackStackChanged() {
        TODO("Not yet implemented")
    }




    fun OnButtonClickFind(view: View) {
        bluetoothDevices.findESP();
        Log.d("ESP", bluetoothDevices.espDevice.toString())
        if (bluetoothDevices.espDevice != null) {
            siema = "POLACZONO"
        } else {
            siema ="NIEPOLOCZONO"
        }

            var intent = Intent(applicationContext, FindBluetoothDevicesActivity::class.java);
                intent.putExtra("siema", siema)
            startActivity(intent)
    }

    fun OnButtonClickBuletoothCommunication(view: View) {

    }

    fun OnButtonClickServerCommunication(view: View) {

    }

}