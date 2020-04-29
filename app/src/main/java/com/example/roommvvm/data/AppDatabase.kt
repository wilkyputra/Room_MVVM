package com.example.roommvvm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roommvvm.dao.StudentDao
import com.example.roommvvm.entity.Student
//class ini untuk mendeklarasikan room database yg digunakan dalam aplikasi
@Database(entities = arrayOf(Student::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun studentDao(): StudentDao

    //tempat menyimpan segala object yg otomatis panggil dengan classnya langs//
    companion object {
        private var INSTANCE: AppDatabase? = null

        //berfungsi untuk cek apakah database sudah ada atau belum dalam device
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        AppDatabase::class.java, "student-database")
                        .build()
                }
            }
            return INSTANCE
        }
        //query untuk menghapus instance/database tetapi dalam program aplikasi ini tidak digunakan
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}