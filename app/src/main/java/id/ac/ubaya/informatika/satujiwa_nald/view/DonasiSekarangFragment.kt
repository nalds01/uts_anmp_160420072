package id.ac.ubaya.informatika.satujiwa_nald.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.satujiwa_nald.R


class DonasiSekarangFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_donasi_sekarang, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btn5 = view.findViewById<Button>(R.id.btn5)
        var btn10 = view.findViewById<Button>(R.id.btn10)
        var btn20 = view.findViewById<Button>(R.id.btn20)
        var btn50 = view.findViewById<Button>(R.id.btn50)
        var text = view.findViewById<EditText>(R.id.editTextDonasi)

        btn5.setOnClickListener {
            text.setText("5000")
        }
        btn10.setOnClickListener {
            text.setText("10000")
        }
        btn20.setOnClickListener {
            text.setText("20000")
        }
        btn50.setOnClickListener {
            text.setText("50000")
        }

        var btnKirim = view.findViewById<Button>(R.id.btnKirimDonasi)
        btnKirim.setOnClickListener {
            val action = DonasiSekarangFragmentDirections.actionDonasiThx()
            Navigation.findNavController(it).navigate(action)
        }
    }


}