package com.example.menucondiferentesfunciones.ListApp

import android.app.Dialog
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.menucondiferentesfunciones.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListActivity : AppCompatActivity() {

    private val categories = listOf(
        TaskCategory.Compras,
        TaskCategory.Notas,
        TaskCategory.Otras
    )
    private val tasks = mutableListOf(
        Task("PruebaC", TaskCategory.Compras),
        Task("PruebaN", TaskCategory.Notas),
        Task("PruebaO", TaskCategory.Otras)
    )

    private lateinit var rvCategory: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTask: RecyclerView
    private lateinit var taskAdapter: TaskAdapter

    private lateinit var fabTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponent()
        initListeners()
        initUI()
    }

    private fun initComponent() {
        rvCategory = findViewById(R.id.rvCategories)
        rvTask =findViewById(R.id.rvTask)
        fabTask =findViewById(R.id.fabAddTask)
    }

    private fun initListeners(){
        fabTask.setOnClickListener {  }
    }

    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks)
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = taskAdapter
    }

    private fun showDialog(){
        val dialog = Dialog(this)
    }
}