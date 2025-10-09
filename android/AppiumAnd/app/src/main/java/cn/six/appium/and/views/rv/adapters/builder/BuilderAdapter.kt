package cn.six.appium.and.views.rv.adapters.builder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.six.appium.and.views.rv.adapters.RvViewHolder

class BuilderAdapter(val data: List<BuilderItem>) : RecyclerView.Adapter<RvViewHolder>() {
    override fun getItemCount() = data.size

    override fun getItemViewType(position: Int) = data[position].getViewType()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder
        = RvViewHolder.createViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        if (data.size > position) {
            val datum = data[position]
            datum.render(holder)
        }
    }

    override fun onViewAttachedToWindow(holder: RvViewHolder) {
        val pos = holder.absoluteAdapterPosition
        if(data.size > pos) {
            val item = data[pos]
            item.onAttach(holder)
        }
    }

    override fun onViewDetachedFromWindow(holder: RvViewHolder) {
        val pos = holder.absoluteAdapterPosition
        if(data.size > pos) {
            val item = data[pos]
            item.onDetach(holder)
        }
    }

}