package com.example.desafiolayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafiolayout.adapter.ItemAdapter
import com.example.desafiolayout.data.Datasource
import com.example.desafiolayout.model.QuickAccess


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().loadButtons()
        setupRecyclerView(myDataset)
    }

    private fun setupRecyclerView(myDataset: List<QuickAccess>) {
        val recyclerView = findViewById<RecyclerView>(R.id.quickAccess)
        recyclerView.layoutManager = GridLayoutManager(this, QUICK_ACCESS_COLUMNS)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ItemAdapter(this, myDataset)
    }

    private companion object {
        const val QUICK_ACCESS_COLUMNS = 3
    }
}