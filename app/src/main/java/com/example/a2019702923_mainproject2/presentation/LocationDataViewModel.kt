package com.example.a2019702923_mainproject2.presentation
/*
Bokang Ntovana
2019702923
* */
import android.Manifest
import android.annotation.SuppressLint
import android.app.Application
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.OnCompleteListener
import java.util.*
//This is the view model that handles everything about location of where the user took their notes
@SuppressLint("MissingPermission")
class LocationViewModel(application: Application) : AndroidViewModel(application)
{

    private val _address = MutableLiveData<String>()
    val address: LiveData<String> get() = _address

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application)

    fun fetchLocation() {
        if (hasLocationPermission()) {
            fusedLocationClient.lastLocation.addOnCompleteListener(OnCompleteListener<Location> { task ->
                if (task.isSuccessful && task.result != null) {
                    val location = task.result
                    getAddressFromLocation(location)
                } else {
                    _address.value = "Unable to get location"
                }
            })
        } else {
            _address.value = "Permission not granted"
        }
    }

    private fun getAddressFromLocation(location: Location) {
        val geocoder = Geocoder(getApplication<Application>().applicationContext, Locale.getDefault())
        val addresses: List<Address>? = geocoder.getFromLocation(location.latitude, location.longitude, 1)
        if (!addresses.isNullOrEmpty()) {
            val address: Address = addresses[0]
            _address.value = address.getAddressLine(0)
        } else {
            _address.value = "Unable to get address"
        }
    }

    private fun hasLocationPermission(): Boolean {
        val context = getApplication<Application>().applicationContext
        val fineLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        )
        val coarseLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_COARSE_LOCATION
        )
        return fineLocationPermission == PackageManager.PERMISSION_GRANTED &&
                coarseLocationPermission == PackageManager.PERMISSION_GRANTED
    }
}
