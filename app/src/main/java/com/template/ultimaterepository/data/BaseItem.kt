package com.template.ultimaterepository.data

import androidx.room.Ignore
import com.template.ultimaterepository.recyclerView.GenericAdapter


abstract class BaseItem {
    @Ignore
    var adapterPosition: Int = -1
    @Ignore
    var onListItemViewClickListener: GenericAdapter.OnListItemViewClickListener? = null
}