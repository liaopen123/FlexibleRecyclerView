package com.lph.wearable.flexiblevp2

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class FlexRV @JvmOverloads constructor(val mContext: Context,val attributeSet: AttributeSet?=null,val style :Int = 0):
    RecyclerView.LayoutManager() {
    override fun generateDefaultLayoutParams(): RecyclerView.LayoutParams {
        TODO("Not yet implemented")
    }



}