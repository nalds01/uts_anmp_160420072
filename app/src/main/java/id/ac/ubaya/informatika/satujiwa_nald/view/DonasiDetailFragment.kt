package id.ac.ubaya.informatika.satujiwa_nald.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.satujiwa_nald.R
import id.ac.ubaya.informatika.satujiwa_nald.util.loadImage
import id.ac.ubaya.informatika.satujiwa_nald.viewmodel.DonasiViewModel


class DonasiDetailFragment : Fragment() {

private lateinit var donasiViewModel:DonasiViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donasi_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        donasiViewModel = ViewModelProvider(this).get(DonasiViewModel::class.java)
        if (arguments != null) {
            val donasiId = DonasiDetailFragmentArgs.fromBundle(requireArguments()).donasiID
            donasiViewModel.fetch(donasiId)
        }
        var imgFotoDetail = view.findViewById<ImageView>(R.id.imgFotoDetail)
        var txtNameDetail = view.findViewById<TextView>(R.id.txtNameDetail)
        var txtYayasanDetail = view.findViewById<TextView>(R.id.txtYayasanDetail)
        var txtDeskripsiDetail = view.findViewById<TextView>(R.id.txtDeskripsiDetail)
        var txtDanaSkrg = view.findViewById<TextView>(R.id.txtDanaSkrg)
        var txtDanaButuh = view.findViewById<TextView>(R.id.txtDanaButuh)
        var btnDonasiSkrgDetail = view.findViewById<Button>(R.id.btnDonasiSekarangDetail)



        donasiViewModel.donasiLD.observe(viewLifecycleOwner) { donasiDetail ->
            imgFotoDetail.loadImage(donasiDetail.photoURL.toString())
            txtNameDetail.setText(donasiDetail.nama.toString())
            txtYayasanDetail.setText(donasiDetail.yayasan.toString())
            txtDeskripsiDetail.setText(donasiDetail.deskripsi.toString())
            txtDanaSkrg.setText(donasiDetail.danaSekarang.toString())
            txtDanaButuh.setText(donasiDetail.danaButuh.toString())

            btnDonasiSkrgDetail.setOnClickListener {
                val action = DonasiDetailFragmentDirections.actionDonasiSekarang()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}