package id.ac.ubaya.informatika.satujiwa_nald.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import id.ac.ubaya.informatika.satujiwa_nald.R
import id.ac.ubaya.informatika.satujiwa_nald.viewmodel.DonasiSayaViewModel
import id.ac.ubaya.informatika.satujiwa_nald.viewmodel.DonasiViewModel


class DonasiSayaListFragment : Fragment() {

    private lateinit var donasiSayaViewModel:DonasiSayaViewModel
    private val donasiSayaListAdapter = DonasiSayaListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donasi_saya_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        donasiSayaViewModel = ViewModelProvider(this).get(DonasiSayaViewModel::class.java)
        donasiSayaViewModel.refresh()

        val recView = view.findViewById<RecyclerView>(R.id.recView)
        recView?.layoutManager = LinearLayoutManager(context)
        recView?.adapter = donasiSayaListAdapter
        val refreshLayout = view.findViewById<SwipeRefreshLayout>(R.id.refreshLayout)
        refreshLayout.setOnRefreshListener {
            recView.visibility = View.GONE
            donasiSayaViewModel.refresh()
            refreshLayout.isRefreshing = false
        }
        observeViewModel()

    }
    fun observeViewModel(){
        donasiSayaViewModel.donasiSayaLD.observe(viewLifecycleOwner,{donasiSayaListAdapter.updateDonasiSayaList(it)})
    }

}