package id.ac.ubaya.informatika.satujiwa_nald.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.satujiwa_nald.R
import id.ac.ubaya.informatika.satujiwa_nald.model.DonasiSaya
import id.ac.ubaya.informatika.satujiwa_nald.util.loadImage

//class DonasiSayaListAdapter {
//}
class DonasiSayaListAdapter (val donasiSayaList:ArrayList<DonasiSaya>)
    : RecyclerView.Adapter<DonasiSayaListAdapter.DonasiSayaViewHolderr>()
{
    class DonasiSayaViewHolderr(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DonasiSayaViewHolderr {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.donasisaya_list_item, parent, false)
        return DonasiSayaViewHolderr(view)
    }

    override fun onBindViewHolder(holder: DonasiSayaViewHolderr, position: Int) {

        val txtName = holder.view.findViewById<TextView>(R.id.txtName)
        val txtYayasan = holder.view.findViewById<TextView>(R.id.txtYayasan)
        val txtDonasiSaya = holder.view.findViewById<TextView>(R.id.txtDonasiSaya)
        val btnDetail = holder.view.findViewById<TextView>(R.id.btnDetail)

        txtName.text = donasiSayaList[position].nama
        txtYayasan.text = donasiSayaList[position].yayasan
        txtDonasiSaya.text = donasiSayaList[position].danaSaya.toString()

        val donasiSayaID = donasiSayaList[position].id

        btnDetail.setOnClickListener {
            val action = DonasiSayaListFragmentDirections.actionDonasiSayaDetail(donasiSayaID.toString())
            Navigation.findNavController(it).navigate(action)
        }
        var imgFoto = holder.view.findViewById<ImageView>(R.id.imgFotoItem)
        imgFoto.loadImage(donasiSayaList[position].photoURL)
    }

    override fun getItemCount(): Int {
        return donasiSayaList.size
    }
    fun updateDonasiSayaList(newDonasiSayaList: ArrayList<DonasiSaya>){
        donasiSayaList.clear()
        donasiSayaList.addAll(newDonasiSayaList)
        notifyDataSetChanged()
    }
}