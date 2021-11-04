package com.example.desafiolayout.data

import com.example.desafiolayout.R
import com.example.desafiolayout.model.QuickAccess

class Datasource {

    fun loadButtons(): List<QuickAccess> {
        return listOf<QuickAccess>(
            QuickAccess(R.string.test1, R.drawable.diamond_icon),
            QuickAccess(R.string.test2, R.drawable.diamond_icon),
            QuickAccess(R.string.test3, R.drawable.diamond_icon),
            QuickAccess(R.string.test4, R.drawable.diamond_icon),
        )
    }
}