package by.academy.hwTomal.hw5

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.IBinder
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.content.IntentFilter
import android.os.Binder
import android.support.v4.content.LocalBroadcastManager


class CustomService : Service() {
    private var myBinder = MyBinder()

    companion object {
        val wifiManager = WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION
        val wifiManagerExtra = WifiManager.EXTRA_SUPPLICANT_CONNECTED
        val INTENT_ACTION = "INTENT_ACTION"
        val EXTRA_KEY = "EXTRA_KEY"
    }

    override fun onBind(intent: Intent?): IBinder? {
        registerReceiver(broadCastReceiver, IntentFilter(wifiManager))
        return myBinder
    }

    inner class MyBinder : Binder() {
        fun getService(): CustomService? {
            return this@CustomService
        }
    }

    override fun unbindService(conn: ServiceConnection) {
        super.unbindService(conn)
        unregisterReceiver(broadCastReceiver)
    }

    fun checkWifiStatus() {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
        sendWifiStatus(networkInfo?.isConnected)
    }

    fun sendWifiStatus(status: Boolean?) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent(INTENT_ACTION).putExtra(EXTRA_KEY, status))
    }

    private val broadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action.equals(wifiManager)) {
                when (intent?.getBooleanExtra(wifiManagerExtra, false)) {
                    true -> sendWifiStatus(true)
                    false -> sendWifiStatus(false)
                }
            }
        }
    }
}