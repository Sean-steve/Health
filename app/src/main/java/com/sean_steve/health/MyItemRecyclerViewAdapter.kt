package com.sean_steve.health

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater.from
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.sean_steve.health.placeholder.PlaceholderContent.PlaceholderItem

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private var titles: List<String>, private var details:List<String>, private var images:List<Int>) :
    RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var itemTitle:TextView=itemView.findViewById(R.id.rv_title)
        var itemDetails:TextView=itemView.findViewById(R.id.rv_desc)
        var itemPicture:ImageView=itemView.findViewById(R.id.rv_image)

        init {
            itemView.setOnClickListener { v: View ->
                val position:Int= absoluteAdapterPosition
                Toast.makeText(itemView.context,"You clicked item # ${position+1}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View =from(parent.context).inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(v)


    }
    override fun getItemCount(): Int {
        return titles.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemTitle.text= titles[position]
        holder.itemDetails.text=details[position]
        holder.itemPicture.setImageResource(images[position])
    }



}



