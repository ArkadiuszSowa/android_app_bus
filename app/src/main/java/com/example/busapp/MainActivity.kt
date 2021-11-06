package com.example.busapp

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.application_start)

    }


    fun OnButtonClickFind(view: View) {
            var intent = Intent(applicationContext, FindBluetoothDevicesActivity::class.java);
            startActivity(intent)
    }

    fun OnButtonClickBuletoothCommunication(view: View) {

    }

    fun OnButtonClickServerCommunication(view: View) {

    }

    override fun onBackStackChanged() {
        TODO("Not yet implemented")
    }
}