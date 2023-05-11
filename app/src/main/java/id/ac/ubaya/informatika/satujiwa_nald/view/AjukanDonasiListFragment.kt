package id.ac.ubaya.informatika.satujiwa_nald.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import id.ac.ubaya.informatika.satujiwa_nald.R


class AjukanDonasiListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ajukan_donasi_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var btnAjukan = view.findViewById<Button>(R.id.btnAjukan)
        btnAjukan.setOnClickListener {
            val action = AjukanDonasiListFragmentDirections.actionAjukanTUnggu()
            Navigation.findNavController(it).navigate(action)
        }
    }

}