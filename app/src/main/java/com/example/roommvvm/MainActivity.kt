package com.example.roommvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.roommvvm.fragment.NameListFragment
import com.example.roommvvm.fragment.NewNameFragment
import timber.log.Timber


//class ini adalah class yg terintegritas dengan view utama ketika program dijalankan//
class MainActivity : AppCompatActivity(),
    NewNameFragment.OnFragmentInteractionListener,
    NameListFragment.OnFragmentInteractionListener{

    //fungsi utama dalam class yg dipanggil pertama kali
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            goToStudentListFragment()
            //memanggil fungsi untuk menampilkan fragment student list
        }
        //menampilkan log dari proses debug
        Timber.plant(Timber.DebugTree())
    }
    //memanggil fungsi untuk menampilkan fragment name list
    override fun goToStudentListFragment() {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.flContent, NameListFragment.newInstance())
        transaction.commit()
    }
    //memanggil fungsi untuk menampilkan fragment new name
    override fun goToNewNameFragment() {
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(R.id.flContent, NewNameFragment.newInstance())
        transaction.commit()
    }
}
