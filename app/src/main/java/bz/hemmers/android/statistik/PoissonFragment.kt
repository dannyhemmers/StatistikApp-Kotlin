package bz.hemmers.android.statistik

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_poisson.view.*
import java.lang.Math.E
import java.lang.Math.pow
import java.text.DecimalFormat


/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [PoissonFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [PoissonFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PoissonFragment : Fragment() {

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
        getActivity().setTitle("Poisson Verteilung")

        //RootView ist das Layout des PoissonFragments
        val rootView = inflater!!.inflate(R.layout.fragment_poisson, container, false)

        //Listener des Buttons
        rootView.poisson_button.setOnClickListener {

            //Variablendeklarationen
            var lambda : Double
            var x : Double
            var ergebnis : Double

            //Format für Ausgabe - Verwendet eine Java Klasse
            var printFormat = DecimalFormat("#.###################")

            //Auslesen der Eingabewerte
            lambda = rootView.poisson_lambda.text.toString().toDouble()
            x = rootView.poisson_x.text.toString().toDouble()

            //Berechnung des Ergebnisses
            ergebnis = ((pow(lambda,x)) / factorial(x.toInt())) * pow(E, (-1 * lambda))

            //Ausgabe in das Textfeld
            rootView.poisson_ergebnis.setText("Ergebnis: " + printFormat.format(ergebnis) + "\n\nProzent: " + printFormat.format(ergebnis*100) + "%")



        }

        return rootView

    }

    //Ursprüngliche Java-Methode von http://www.java2s.com/Code/Java/Development-Class/CaclulatethefactorialofN.htm
    fun factorial(N: Int): Long {
        var multi: Long = 1
        for (i in 1..N) {
            multi = multi * i
        }
        return multi
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
         * @return A new instance of fragment PoissonFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): PoissonFragment {
            val fragment = PoissonFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}// Required empty public constructor
