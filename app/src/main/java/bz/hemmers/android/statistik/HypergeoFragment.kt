package bz.hemmers.android.statistik

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_hypergeo.*
import kotlinx.android.synthetic.main.fragment_hypergeo.view.*
import org.apache.commons.math3.util.CombinatoricsUtils
import java.text.DecimalFormat

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HypergeoFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HypergeoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HypergeoFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    private var mListener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        //Setzen des Titels
        getActivity().setTitle("Hypergeometrische Verteilung")

        //Rootview ist das Layout für die Hypergeometrische Verteilung
        val rootView = inflater!!.inflate(R.layout.fragment_hypergeo, container, false)

        //Listener des Buttons
        rootView.hypergeo_button.setOnClickListener {

            //Variablendeklarationen
            val nsmall : Double
            val m : Double
            val k : Double
            val nbig : Double
            val ergebnis : Double

            //Format für Ausgabe - Verwendet eine Java Klasse
            val printFormat = DecimalFormat("#.###################")

            //Auslesen der eingegebenen Werte
            nsmall = rootView.hypergeo_nsmall.text.toString().toDouble()
            m = rootView.hypergeo_m.text.toString().toDouble()
            k = rootView.hypergeo_k.text.toString().toDouble()
            nbig = rootView.hypergeo_nbig.text.toString().toDouble()

            //Berechnung der Wahrscheinlichkeit
            ergebnis = (CombinatoricsUtils.binomialCoefficient(m.toInt(), k.toInt()).toDouble()) * (CombinatoricsUtils.binomialCoefficient((nbig-m).toInt(),(nsmall-k).toInt())) / (CombinatoricsUtils.binomialCoefficient(nbig.toInt(), nsmall.toInt()))

            //Ausgabe des Textes in der TextView
            rootView.hypergeo_ergebnis.setText("Ergebnis: " + printFormat.format(ergebnis) + "\n\nProzent: " + printFormat.format(ergebnis*100) + "%")

        }

        return rootView
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        if (mListener != null) {
            mListener!!.onFragmentInteraction(uri)
        }
    }


    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html) for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.

         * @param param1 Parameter 1.
         * *
         * @param param2 Parameter 2.
         * *
         * @return A new instance of fragment HypergeoFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): HypergeoFragment {
            val fragment = HypergeoFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
