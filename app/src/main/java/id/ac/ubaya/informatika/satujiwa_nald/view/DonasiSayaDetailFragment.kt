package id.ac.ubaya.informatika.satujiwa_nald.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import id.ac.ubaya.informatika.satujiwa_nald.R
import id.ac.ubaya.informatika.satujiwa_nald.util.loadImage
import id.ac.ubaya.informatika.satujiwa_nald.viewmodel.DonasiSayaDetailViewModel
import id.ac.ubaya.informatika.satujiwa_nald.viewmodel.DonasiViewModel
import org.w3c.dom.Text


class DonasiSayaDetailFragment : Fragment() {
private lateinit var donasiSayaDetailViewModel:DonasiSayaDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donasi_saya_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        donasiSayaDetailViewModel=ViewModelProvider(this).get(DonasiSayaDetailViewModel::class.java)
        if(arguments!=null){
            val donasiSayaID = DonasiSayaDetailFragmentArgs.fromBundle(requireArguments()).donasiSayaID
            donasiSayaDetailViewModel.fetch(donasiSayaID)
        }

        var imgFotoSaya = view.findViewById<ImageView>(R.id.imgFotoSaya)
        var txtNamaSaya = view.findViewById<TextView>(R.id.txtNamaSaya)
        var txtYayasanSaya = view.findViewById<TextView>(R.id.txtYayasanSaya)
        var txtSumbanganSaya = view.findViewById<TextView>(R.id.txtSumbanganSaya)

        donasiSayaDetailViewModel.donasiSayaDetailLD.observe(viewLifecycleOwner){
            donasiSayaDetail->
            imgFotoSaya.loadImage(donasiSayaDetail.photoURL.toString())
            txtNamaSaya.setText(donasiSayaDetail.nama.toString())
            txtYayasanSaya.setText(donasiSayaDetail.yayasan.toString())
            txtSumbanganSaya.setText(donasiSayaDetail.danaSaya.toString())
        }
    }
}