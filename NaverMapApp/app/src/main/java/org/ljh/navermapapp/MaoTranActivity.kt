package org.ljh.navermapapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraPosition
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.MapFragment
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapOptions
import com.naver.maps.map.OnMapReadyCallback
import com.naver.maps.map.overlay.Marker

class MaoTranActivity : AppCompatActivity() ,OnMapReadyCallback{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mao_tran)

        val options = NaverMapOptions()
            .camera(CameraPosition(LatLng(36.1798159, 129.0750222), 8.0))
            .mapType(NaverMap.MapType.Basic)
        val fm = supportFragmentManager
        val mapFragment=fm.findFragmentById(R.id.map) as MapFragment?
            ?:MapFragment.newInstance(options).also {
                fm.beginTransaction().add(R.id.map, it).commit()
            }
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(naverMap: NaverMap) {
        naverMap.mapType=NaverMap.MapType.Basic //기본
//        naverMap.mapType=NaverMap.MapType.Navi 네비용
//        naverMap.mapType=NaverMap.MapType.Terrain 지형지도
//        naverMap.mapType=NaverMap.MapType.Satellite 위성지도
//        naverMap.mapType=NaverMap.MapType.Hybrid 위성 + 도로
        naverMap.setLayerGroupEnabled(NaverMap.LAYER_GROUP_TRAFFIC,true)
        val coord = LatLng(35.5670135, 127.9783740)
        val cameraUpdate=CameraUpdate.scrollTo(LatLng(35.1798159, 129.0750222))
            .animate(CameraAnimation.Fly,4000)
//        naverMap.moveCamera(cameraUpdate)

        val marker= Marker()
        marker.position=LatLng(35.1798159, 129.0750222)
        marker.map=naverMap

        Toast.makeText(this,
            "위도: ${coord.latitude}, 경도: ${coord.longitude}",
            Toast.LENGTH_SHORT).show()
    }
}