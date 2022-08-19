package me.hirotask.android.todoapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var todoList = ArrayList<TodoData>()
    private lateinit var recyclerView: RecyclerView
    private var recyclerAdapter = RecyclerAdapter(todoList)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Viewを取得
        recyclerView = findViewById(R.id.rv)
        //アダプターに入れてRecyclerViewにセット
        recyclerView.adapter = recyclerAdapter
        //縦に並べるようにレイアウトを設定
        recyclerView.layoutManager = LinearLayoutManager(this)

        val addFab : FloatingActionButton = findViewById(R.id.addFab)
        addFab.setOnClickListener {
            val et = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("Todoを追加")
                .setView(et)
                .setPositiveButton("追加", DialogInterface.OnClickListener {
                    dialogInterface, i ->
                    //addListに追加する
                    val mytodo = et.text.toString()
                    todoList.add(TodoData(mytodo))
                    recyclerAdapter.notifyItemInserted(todoList.lastIndex)
                })
                .setNegativeButton("キャンセル", null)
                .show()
        }
    }


}