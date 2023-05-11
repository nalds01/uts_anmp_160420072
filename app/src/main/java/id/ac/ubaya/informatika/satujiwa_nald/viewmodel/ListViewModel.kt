package id.ac.ubaya.informatika.satujiwa_nald.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import id.ac.ubaya.informatika.satujiwa_nald.model.Donasi

//class ListViewModel :ViewModel() {
class ListViewModel (application: Application):AndroidViewModel(application){

    val donasiLD = MutableLiveData<ArrayList<Donasi>>()
    val donasiLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    val TAG = "ronald"
    private var queue: RequestQueue? = null

    fun refresh(){
        donasiLoadErrorLD.value = false
        loadingLD.value = false
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.18.11/anmp/donasi.php?param=donasi"
        val stringRequest = StringRequest(
            Request.Method.GET,url,{

                val sType = object :TypeToken<List<Donasi>>(){}.type
                val result = Gson().fromJson<ArrayList<Donasi>>(it,sType)
                donasiLD.value=result
                loadingLD.value = false
                Log.d("showvoley", it)

            },
            {

                Log.d("showvoley", it.toString())
                donasiLoadErrorLD.value = false
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