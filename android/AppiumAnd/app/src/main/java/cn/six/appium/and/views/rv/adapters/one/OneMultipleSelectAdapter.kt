package cn.six.appium.and.views.rv.adapters.one

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.six.appium.and.views.rv.adapters.RvViewHolder

abstract class OneMultipleSelectAdapter<T>(val layoutResId: Int, val data: List<T> = ArrayList()) :
    RecyclerView.Adapter<RvViewHolder>() {
    private var selectedIndexes = hashSetOf<Int>() //用set, 是为了避免重复

    override fun getItemViewType(position: Int): Int = layoutResId

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        return RvViewHolder.createViewHolder(parent, layoutResId)
    }

    // 没有设置的话, 那默认itemviewType就是0
    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        if (data.size <= position) { return }
        val value = data[position]
        if(selectedIndexes.contains(position)) {
            renderSelected(holder, value, position)
        } else {
            renderUnselected(holder, value, position)
        }

        val rootView = holder.rootView<View>()
        rootView.setOnClickListener {
            // 点击已选中项, 就是取消选中
            if (selectedIndexes.contains(position)) selectedIndexes.remove(position)
            else selectedIndexes.add(position)
            notifyItemChanged(position)
            onClickItem(holder, value, position)
        }
    }

    // = = = = = = = = = 可重现的几个方法 = = = = = = = = =
    // render2方法是子类必须要实现的; onClickItem是可选实现的, 子类若没需求, 可以不实现它

    //防备点击整个item, 除了选择, 还有其它功能. 到时可以comment in本行
    protected open fun onClickItem(vh: RvViewHolder, value: T, position: Int)  { /* 故意空实现. 因为有些子类可能不需要实现它*/ }

    protected abstract fun renderUnselected(vh: RvViewHolder, value: T, position: Int)
    protected abstract fun renderSelected(vh: RvViewHolder, value: T, position: Int)

}