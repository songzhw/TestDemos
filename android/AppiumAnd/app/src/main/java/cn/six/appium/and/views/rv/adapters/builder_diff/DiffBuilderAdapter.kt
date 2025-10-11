package cn.six.appium.and.views.rv.adapters.builder_diff

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import cn.six.appium.and.views.rv.adapters.RvViewHolder
import cn.six.appium.and.views.rv.adapters.builder.BuilderItem

class DiffBuilderAdapter(
    val myDiff: DiffUtil.ItemCallback<BuilderItem>,
) : ListAdapter<BuilderItem, RvViewHolder>(myDiff) {

    override fun getItemViewType(position: Int): Int {
        val datum = getItem(position)
        return datum.getViewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RvViewHolder.createViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val datum = getItem(position)
        datum.render(holder)
    }

}