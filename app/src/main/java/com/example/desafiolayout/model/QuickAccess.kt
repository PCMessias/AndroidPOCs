package com.example.desafiolayout.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class QuickAccess(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
)