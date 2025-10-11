package cn.six.appium.and.views.rv.adapters.builder

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cn.six.appium.and.views.rv.adapters.RvViewHolder
import cn.six.appium.and.views.rv.adapters.builder_diff.DiffBuilderAdapter

class BuilderAdapterWrapper {
    val list = arrayListOf<BuilderItem>()

    fun addSection(vararg items: BuilderItem, precondition: () -> Boolean) {
        if (precondition()) {
            list.addAll(items)
        }
    }

    fun add(item: BuilderItem) {
        list.add(item)
    }

    fun clear() {
        list.clear()
    }

    fun generateAdapter(): RecyclerView.Adapter<RvViewHolder> {
        return BuilderAdapter(list)
    }

    fun generateLoopAdapter(): BuilderLoopAdapter {
        return BuilderLoopAdapter(list)
    }

    fun generateDiffAdapter(myDiff: DiffUtil.ItemCallback<BuilderItem>): ListAdapter<BuilderItem, RvViewHolder> {
        return DiffBuilderAdapter(myDiff)
    }

}