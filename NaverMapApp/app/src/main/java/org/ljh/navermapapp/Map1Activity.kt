package org.ljh.navermapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naver.maps.map.NaverMapSdk

class Map1Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map1)
//        NaverMapSdk.getInstance(this).client =
//            NaverMapSdk.NaverCloudPlatformClient("ovhh03pmk3")
    }
}