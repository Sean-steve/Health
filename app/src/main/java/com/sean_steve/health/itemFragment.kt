package com.sean_steve.health

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


/**
 * A fragment representing a list of Items.
 */
class itemFragment : Fragment() {
    var titlesList= mutableListOf<String>()
    var descriptionsList= mutableListOf<String>()
    var imagesList= mutableListOf<Int>()

    private var columnCount = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
            postToList()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        postToList()
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                    adapter=MyItemRecyclerViewAdapter(titlesList, descriptionsList,
                    imagesList)

            }
        }
        return view


    }
    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            itemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }

    private fun addToList(title: String, description:String, image:Int){
        titlesList.add(title)
        descriptionsList.add(description)
        imagesList.add(image)
    }
    private fun postToList(){
        for (i: Int in 1..25){
            addToList("PTSD","Bad Illness",R.mipmap.ic_launcher)}
    }
}

