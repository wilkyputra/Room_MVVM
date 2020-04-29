package com.example.roommvvm.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders

import com.example.roommvvm.R
import com.example.roommvvm.viewmodel.NewStudentViewModel
import kotlinx.android.synthetic.main.fragment_new_name.*

/**
 * A simple [Fragment] subclass.
 */
//class yg digunakan ketika memanggil tampilan fragment
class NewNameFragment : Fragment() {

    private var listener: OnFragmentInteractionListener? = null

    private lateinit var mViewModel: NewStudentViewModel

    //ini fungsi utama dalam class yg dipanggil pertama kali ketika class dipanggil
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mViewModel = ViewModelProviders.of(this).get(NewStudentViewModel::class.java)
    }

    //fungsi pemanggil view dipanggil pertama kali ketika class dipanggil
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_name, container, false)
    }

    //fungsi yg pertama dipanggil ketika view dipanggil
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            val input = editText.text.toString().trim()

            if (input.isEmpty()) {
                Toast.makeText(activity, "Nama dibutuhkan", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (input.length > 30) {
                Toast.makeText(activity, "Nama terlalu panjang", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            mViewModel.storeMovie(input)

            Toast.makeText(activity, "$input entered", Toast.LENGTH_SHORT).show()
            listener?.goToStudentListFragment()
        }
    }

    //fungsi yg berjalan ketika fragment diaktifkan
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    //fungsi yg berjalan ketika fragment dinonaktifkan atau replaced
    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        fun goToStudentListFragment()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewNameFragment()
    }
}
