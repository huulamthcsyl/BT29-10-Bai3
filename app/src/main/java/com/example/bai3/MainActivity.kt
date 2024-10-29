package com.example.bai3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var studentListView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        studentListView = findViewById(R.id.studentListview)

        val students = listOf(
            StudentModel("17020001", "Nguyen Van A"),
            StudentModel("17020002", "Le Van B"),
            StudentModel("17020003", "Tran Thi C"),
            StudentModel("17020004", "Pham Van D"),
            StudentModel("17020005", "Nguyen Thi E"),
            StudentModel("17020006", "Le Van F"),
            StudentModel("17020007", "Tran Van G"),
            StudentModel("17020008", "Pham Thi H"),
            StudentModel("17020009", "Nguyen Van I"),
            StudentModel("17020010", "Le Thi K"),
        )

        studentListView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        studentListView.adapter = StudentAdapter(students)

        findViewById<EditText>(R.id.studentNameTxt).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().length <= 2){
                    studentListView.adapter = StudentAdapter(students)
                    return
                }
                val studentFilter = students.filter { it.name.contains(s.toString(), ignoreCase = true) || it.mssv.contains(s.toString(), ignoreCase = true) }
                studentListView.adapter = StudentAdapter(studentFilter)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}