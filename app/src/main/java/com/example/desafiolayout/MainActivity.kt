package com.example.desafiolayout

import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiolayout.adapter.ItemAdapter
import com.example.desafiolayout.data.Datasource
import androidx.recyclerview.widget.GridLayoutManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().loadButtons()
        val recyclerView = findViewById<RecyclerView>(R.id.quickAccess)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.setHasFixedSize(true)
        recyclerView.addItemDecoration(object: RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
            }
        })
        recyclerView.adapter = ItemAdapter(this, myDataset)

    }
}