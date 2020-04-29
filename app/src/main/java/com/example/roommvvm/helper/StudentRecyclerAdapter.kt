package com.example.roommvvm.helper

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roommvvm.R
import com.example.roommvvm.entity.Student

//class yg berisi adapter dari list data tabel student melalui Reccler View
class StudentRecyclerAdapter(private val myDataset: List<Student>):
        RecyclerView.Adapter<StudentRecyclerAdapter.StudentViewHolder>() {

    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tvName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)

        return StudentViewHolder(v)
    }

    //fungsi untuk menghitung jumlah data yg diterima adapter
    override fun getItemCount(): Int {
        return myDataset.size
    }

    //fungsi untuk mengatur cara penampilan data
    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.tvName.text = myDataset[position].name
    }
}