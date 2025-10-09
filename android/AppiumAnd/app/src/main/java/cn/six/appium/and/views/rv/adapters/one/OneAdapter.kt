package cn.six.appium.and.views.rv.adapters.one

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.six.appium.and.views.rv.adapters.RvViewHolder

abstract class OneAdapter<T>(val layoutResId: Int, var data: List<T> = ArrayList())
    : RecyclerView.Adapter<RvViewHolder>() {

    override fun getItemViewType(position: Int): Int = layoutResId

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder.createViewHolder(parent, layoutResId)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        if (data.size > position) {
            apply(holder, data[position], position)
        }
    }

    protected abstract fun apply(vh: RvViewHolder, value: T, position: Int)
}