package id.ac.ubaya.informatika.satujiwa_nald.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.satujiwa_nald.R
import id.ac.ubaya.informatika.satujiwa_nald.util.loadImage
import id.ac.ubaya.informatika.satujiwa_nald.model.Donasi

class DonasiListAdapter (val donasiList:ArrayList<Donasi>)
    :RecyclerView.Adapter<DonasiListAdapter.DonasiViewHolder>()
{
    class DonasiViewHolder (var view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonasiViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.donasi_list_item,parent,false)
        return  DonasiViewHolder(view)
    }

    override fun onBindViewHolder(holder: DonasiViewHolder, position: Int) {
        val txtName = holder.view.findViewById<TextView>(R.id.txtName)
        val txtYayasan = holder.view.findViewById<TextView>(R.id.txtYayasan)
        val txtDanaSekarang = holder.view.findViewById<TextView>(R.id.txtDonasiSaya)
        val txtHari = holder.view.findViewById<TextView>(R.id.txtHari)

        txtName.text = donasiList[position].nama
        txtYayasan.text = donasiList[position].yayasan
        txtDanaSekarang.text = donasiList[position].danaSekarang.toString()
        txtHari.text = donasiList[position].hari

        val donasiID = donasiList[position].id
        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
        btnDetail.setOnClickListener {
            val action = DonasiListFragmentDirections.actionDonasiDetail(donasiID.toString())
            Navigation.findNavController(it).navigate(action)
        }
        var imgFoto = holder.view.findViewById<ImageView>(R.id.imgFotoItem)
        imgFoto.loadImage(donasiList[position].photoURL)
    }

    override fun getItemCount(): Int {
        return  donasiList.size
    }

    fun updateDonasiList(newDonasiList:ArrayList<Donasi>){
        donasiList.clear()
        donasiList.addAll(newDonasiList)
        notifyDataSetChanged()
    }
}