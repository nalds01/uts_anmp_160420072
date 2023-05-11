package id.ac.ubaya.informatika.satujiwa_nald.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.satujiwa_nald.model.Donasi

//class DonasiViewModel {
//}
class DonasiViewModel(application: Application): AndroidViewModel(application) {
    val donasiLD = MutableLiveData<Donasi>()
    val TAG = "ronald"
    private  var queue: RequestQueue?=null
    val url = "http://192.168.18.11/anmp/donasi.php?param=donasi"
    fun fetch(id:String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.18.11/anmp/donasi.php?param=donasi&id=$id"
        val stringRequest = StringRequest(
            Request.Method.GET,url,{
                val sType = object : TypeToken<List<Donasi>>() { }.type
                val result = Gson().fromJson<Donasi>(it,Donasi::class.java)
                donasiLD.value = result

                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}