package com.goldden.lucck.volunteerapp

import android.view.ViewTreeObserver
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.goldden.lucck.volunteerapp.Models.TrackModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions

@Composable
fun TrackOrderScreen() {
    // Припустимо, у вас є екземпляр TrackModel, давайте назвемо його trackModel
    val trackModel = TrackModel(
        name = "Example Name",
        photo = R.drawable.img,
        description = "Example Description",
        id = 1,
        city = "City 1",
        city_1 = "City 2",
        owned = true,
        submitted = false
    )

    // Побудова UI для мапи або використання існуючого компоненту для карт
    // Замініть на свій власний код для побудови мапи
    MapComponent(city1 = trackModel.city, city2 = trackModel.city_1)

    // Додайте решту вашого коду для інших частин екрану TrackOrderScreen
}

@Composable
fun MapComponent(city1: String, city2: String) {
    var mapView: MapView? by remember { mutableStateOf(null) }
    var googleMap: GoogleMap? by remember { mutableStateOf(null) }

    val context = LocalContext.current as ComponentActivity

    DisposableEffect(context) {
        mapView = MapView(context)
        mapView?.getMapAsync(OnMapReadyCallback { map ->
            googleMap = map
            val location1 = getLocationFromCityName(city1)
            val location2 = getLocationFromCityName(city2)

            // Додайте маркери для двох міст
            googleMap?.addMarker(MarkerOptions().position(location1).title(city1))
            googleMap?.addMarker(MarkerOptions().position(location2).title(city2))

            // Приблизьте камеру до області з двома маркерами
            val bounds = LatLngBounds.builder().include(location1).include(location2).build()
            googleMap?.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100))
        })

        onDispose {
            mapView?.onPause()
        }
    }

    // Замініть "fillMaxSize()" на ваші потреби
    Box(modifier = Modifier.fillMaxSize()) {
        mapView?.let { mapView ->
            AndroidView(factory = { mapView }) { mapView ->
                mapView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
                    override fun onPreDraw(): Boolean {
                        mapView.onResume()
                        mapView.viewTreeObserver.removeOnPreDrawListener(this)
                        return true
                    }
                })
            }
        }
    }
}

// Метод для отримання координат з назви міста (потрібно власноруч реалізувати)
private fun getLocationFromCityName(city: String): LatLng {
    // Ваш код для отримання координат з назви міста
    // Поверніть LatLng з координатами міста
    return LatLng(49.842957, 24.031111) // Приклад; замініть його реальними координатами
}