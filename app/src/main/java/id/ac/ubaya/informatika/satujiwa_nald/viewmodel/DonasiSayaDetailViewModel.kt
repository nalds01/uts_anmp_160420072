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
import id.ac.ubaya.informatika.satujiwa_nald.model.DonasiSaya

//class DonasiSayaDetailViewModel {
//}

class DonasiSayaDetailViewModel (application: Application): AndroidViewModel(application){
    val donasiSayaDetailLD = MutableLiveData<DonasiSaya>()
    val TAG = "ronald"
    private var queue:RequestQueue?=null
    val url = "http://192.168.18.11/anmp/donasi.php?param=donasi_saya"
    fun fetch(id:String){
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.18.11/anmp/donasi.php?param=donasi_saya&id=$id"
        val stringRequest = StringRequest(
            Request.Method.GET,url,{
                val sType = object : TypeToken<List<DonasiSaya>>() { }.type
                val result = Gson().fromJson<DonasiSaya>(it,DonasiSaya::class.java)
               donasiSayaDetailLD.value = result

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