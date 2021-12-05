package com.system.assignment.ui.adapter

import com.system.assignment.data.local.entity.User

/**
 * Created by Kaushik Burkule on 05-12-2021 in Assignment
 * of package com.system.assignment.ui.adapter
 */
interface RecyclerViewCallback {

    fun position(position: User, b: Boolean)

}