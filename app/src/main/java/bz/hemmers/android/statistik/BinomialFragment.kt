package bz.hemmers.android.statistik

import android.content.Context
import android.content.DialogInterface
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_binomial.*
import kotlinx.android.synthetic.main.fragment_binomial.view.*
import java.util.concurrent.atomic.DoubleAdder
import org.apache.commons.*
import org.apache.commons.math3.util.CombinatoricsUtils
import java.lang.Math.pow


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BinomialFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BinomialFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BinomialFragment : Fragment() {

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
        getActivity().setTitle("Binomialverteilung")

        //RootView ist das Layout des BinomialFragments
        val rootView : View = inflater!!.inflate(R.layout.fragment_binomial, container, false)

        //Listener des Buttons
        rootView.binomial_button.setOnClickListener {

            //Variablendeklarationen
            var n : Double
            val p : Double
            val k : Double
            val ergebnis : Double

            //Auslesen der Werte aus den Eingabefeldern
            n = rootView.binomial_n.text.toString().toDouble()
            p = rootView.binomial_p.text.toString().toDouble()
            k = rootView.binomial_k.text.toString().toDouble()

            //Berechnung der Wahrscheinlichkeit
            ergebnis = CombinatoricsUtils.binomialCoefficient(n.toInt(), k.toInt()).toDouble() * pow(p,k) * pow((1-p), (n-k))

            //Ausgabe des Ergebnisses
            rootView.binomial_ergebnis.setText("Ergebnis: " + ergebnis.toString() + "\n\nProzent: " + (ergebnis*100).toString() + "%")

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
         * @return A new instance of fragment BinomialFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): BinomialFragment {
            val fragment = BinomialFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
