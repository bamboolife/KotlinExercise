package com.sundy.test.lifecycle

import android.content.Context
import android.location.Location
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

class MyLocationListener(private val context:Context,private val lifecycle: Lifecycle,private val callback:(String)->Unit) :LifecycleEventObserver{
    private val TAG = "my_test"
    private var enabled=false

    fun enable(){
        enabled=true
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)){
            Log.i("my_test", "onStart开启: ")
            callback.invoke("开启回掉了")
        }
    }


    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_CREATE->{

            }
            Lifecycle.Event.ON_START->{
                if (enabled){
                    Log.i(TAG, "onStart: ")
                    callback.invoke("回掉了")
                }
            }
            Lifecycle.Event.ON_RESUME->{

            }
            Lifecycle.Event.ON_PAUSE->{
                Log.i(TAG, "onPause开启: ")
            }
            Lifecycle.Event.ON_STOP->{
                Log.i(TAG, "onStop开启: ")
            }
            Lifecycle.Event.ON_DESTROY->{

            }

            else -> {

            }
        }
    }
}