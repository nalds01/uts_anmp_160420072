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

//class DonasiSayaViewModel {
//}

class DonasiSayaViewModel (application: Application): AndroidViewModel(application){
    val donasiSayaLD = MutableLiveData<ArrayList<DonasiSaya>>()
    val donasiSayaLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "ronald"
    private  var queue: RequestQueue?=null

    fun refresh(){
        loadingLD.value = true
        donasiSayaLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url ="http://192.168.18.11/anmp/donasi.php?param=donasi_saya"
        val stringRequest = StringRequest(
            Request.Method.GET,url,{
                val sType = object : TypeToken<List<DonasiSaya>>(){}.type
                val result = Gson().fromJson<ArrayList<DonasiSaya>>(it,sType)
                donasiSayaLD.value = result
                loadingLD.value = false
                Log.d("showVolley",result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                donasiSayaLoadErrorLD.value = true
                loadingLD.value = false
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}