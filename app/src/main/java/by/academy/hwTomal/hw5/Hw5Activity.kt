package by.academy.hwTomal.hw5

import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_hw5.*
import android.support.v4.content.LocalBroadcastManager
import by.academy.android_hw_tomal.R


class Hw5Activity : AppCompatActivity() {
    private lateinit var customService: CustomService
    private lateinit var broadCastReceiver: BroadcastReceiver
    private var isBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hw5)
        checkServiceButton.setOnClickListener {
            if (isBound)
                customService.checkWifiStatus()
        }
    }

    override fun onStart() {
        super.onStart()
        bindService(Intent(this, CustomService::class.java), myConnection, BIND_AUTO_CREATE)
        broadCastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when (intent?.getBooleanExtra(CustomService.EXTRA_KEY, false)) {
                    true -> wifiStatus.setBackgroundResource(R.drawable.wifi_on)
                    false -> wifiStatus.setBackgroundResource(R.drawable.wifi_off)
                }
            }
        }
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(broadCastReceiver, IntentFilter(CustomService.INTENT_ACTION))
    }

    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadCastReceiver)
        unbindService(myConnection);
    }

    private val myConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            val binder = service as CustomService.MyBinder
            customService = binder.getService()!!
            isBound = true
        }

        override fun onServiceDisconnected(name: ComponentName) {
            isBound = false
        }
    }
}