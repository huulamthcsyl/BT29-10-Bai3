package com.example.bai3

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class StudentAdapter (private val students: List<StudentModel>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mssvTxt: TextView = itemView.findViewById(R.id.mssvTxt)
        val nameTxt: TextView = itemView.findViewById(R.id.nameTxt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.student_item, parent, false)
        return StudentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = students[position]
        holder.mssvTxt.text = student.mssv
        holder.nameTxt.text = student.name
    }

    override fun getItemCount(): Int {
        return students.size
    }
}
