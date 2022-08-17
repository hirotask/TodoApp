package me.hirotask.android.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(private val todoList : ArrayList<TodoData>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolderItem>() {

    inner class ViewHolderItem(v : View) : RecyclerView.ViewHolder(v) {
        val itemName : TextView = v.findViewById(R.id.tv)
    }

    //一つのViewHolderを作成する処理
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItem {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.one_item, parent, false)

        return ViewHolderItem(item)
    }

    override fun onBindViewHolder(holder: ViewHolderItem, position: Int) {
        holder.itemName.text = todoList[position].todo
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

}