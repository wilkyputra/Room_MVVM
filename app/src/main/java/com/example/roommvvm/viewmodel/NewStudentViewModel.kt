package com.example.roommvvm.viewmodel

import android.app.Application
import android.graphics.Movie
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.roommvvm.data.AppDatabase
import com.example.roommvvm.entity.Student
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import timber.log.Timber

class NewStudentViewModel(application: Application) : AndroidViewModel(application) {
    //deklarasi variabel yg dibutuhkan (memanggil database dan tabel student)
    private val mDb: AppDatabase? = AppDatabase.getInstance(application)
    private val allStudent = MutableLiveData<List<Student>>()

    fun storeMovie(title: String) {

        //memasukkan data tabel studnet ke variabel
        val student = Student()
        student.name = title

        GlobalScope.launch {
            mDb?.studentDao()?.insertStudent(student)
        }
    }

    //fungsi yg berguna untuk mengambil/menampilkan data
    fun retrieveStudent(): LiveData<List<Student>> {

        //untuk menjalankan query select yg tersimpan dalam StudentDao
        GlobalScope.launch {
            val list = mDb?.studentDao()?.getAll()

            //ketika query berjalan akan menghasilkan feedback berisikan count data dari tabel student
            Timber.i("Data yang ada sejumlah {${list?.size}}")
            allStudent.postValue(list)
        }

        return allStudent
    }
}