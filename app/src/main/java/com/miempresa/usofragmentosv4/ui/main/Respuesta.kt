package com.miempresa.usofragmentosv4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.miempresa.usofragmentosv4.R
import kotlinx.android.synthetic.main.fragment_respuesta.*
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Respuesta.newInstance] factory method to
 * create an instance of this fragment.
 */
class Respuesta : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =
            inflater.inflate(R.layout.fragment_respuesta, container, false)
        var lbln1 = view.findViewById<TextView>(R.id.lbln1)
        var lbln2 = view.findViewById<TextView>(R.id.lbln2)
        var lbloperacion = view.findViewById<TextView>(R.id.lbloper)
        var lblrpta = view.findViewById<TextView>(R.id.lblres)
        if (arguments != null){
            val dato1 = requireArguments().getString("n1")
            val dato2 = requireArguments().getString("n2")
            val operacion = requireArguments().getString("o")
            var respuesta = 0.0
            lbln1.text=dato1
            lbln2.text=dato2
            when (operacion){
                "suma" -> respuesta = (dato1?.toDouble())!! +(dato2?.toDouble())!!
                "resta" -> respuesta = (dato1?.toDouble())!! -(dato2?.toDouble())!!
                "multiplicacion" -> respuesta = (dato1?.toDouble())!! *(dato2?.toDouble())!!
                "divicion" -> respuesta = (dato1?.toDouble())!! / (dato2?.toDouble())!!
            }
            lbloperacion.text=operacion
            lblrpta.text = respuesta.toString()
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Respuesta.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Respuesta().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}