package com.example.menucondiferentesfunciones.ListApp

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
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
        TaskCategory.Otros
    )
    private val tasks = mutableListOf(
        Task("PruebaC", TaskCategory.Compras),
        Task("PruebaN", TaskCategory.Notas),
        Task("PruebaO", TaskCategory.Otros)
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
        fabTask.setOnClickListener { showDialog() }
    }

    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories){ position -> updateCategories(position) }
        rvCategory.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rvCategory.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks) {position -> onItemSelectec(position)}
        rvTask.layoutManager = LinearLayoutManager(this)
        rvTask.adapter = taskAdapter
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask:Button = dialog.findViewById(R.id.btnAddTask)
        val etTask:EditText = dialog.findViewById(R.id.etTask)
        val rgCategories:RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {
            val selectdId = rgCategories.checkedRadioButtonId
            val currentTask= etTask.text.toString()
            if(currentTask.isNotEmpty()){
                val selectedRB:RadioButton = rgCategories.findViewById(selectdId)
                val currentCategory:TaskCategory = when(selectedRB.text){
                    getString(R.string.listCategoryC) -> TaskCategory.Compras
                    getString(R.string.listCategoryN) -> TaskCategory.Notas
                    else -> TaskCategory.Otros
                }
                tasks.add(Task(currentTask, currentCategory))
                updateTask()
                dialog.hide()
            }
        }
        dialog.show()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTask(){
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTask = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.task = newTask
        taskAdapter.notifyDataSetChanged()
    }

    private fun updateCategories(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTask()
    }

    private fun onItemSelectec(posicion:Int){
        tasks[posicion].isSelected = !tasks[posicion].isSelected
        updateTask()
    }

}