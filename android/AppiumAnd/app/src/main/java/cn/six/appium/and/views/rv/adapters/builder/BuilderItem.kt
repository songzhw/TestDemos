package cn.six.appium.and.views.rv.adapters.builder

import cn.six.appium.and.views.rv.adapters.RvViewHolder

const val NOT_IDENTIFIABLE = "unidentified"

interface BuilderItem {
    fun getViewType(): Int
    fun render(vh: RvViewHolder)

    fun onAttach(vh: RvViewHolder) {} // empty if no need
    fun onDetach(vh: RvViewHolder) {} // empty if no need

    val optionalId: String
        get() = NOT_IDENTIFIABLE
    fun isIdentifiable(): Boolean = optionalId != NOT_IDENTIFIABLE
}