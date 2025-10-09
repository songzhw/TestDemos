package cn.six.appium.and.views.rv.adapters.builder

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cn.six.appium.and.views.rv.adapters.RvViewHolder

class BuilderLoopAdapter(val data: List<BuilderItem>) : RecyclerView.Adapter<RvViewHolder>() {

    override fun getItemCount(): Int = if(data.size == 1) 1 else Int.MAX_VALUE

    override fun getItemViewType(position: Int) : Int {
        val index = getIndexOf(position)
        return data[index].getViewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder
            = RvViewHolder.createViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val index = getIndexOf(position)
        if (data.size > index) {
            val datum = data[index]
            datum.render(holder)
        }
    }

    private fun getIndexOf(position: Int) = position % data.size

    fun getMidIndex(): Int = Math.ceil(itemCount / 2.0).toInt()

    // for example, if you want the index at position 1, then you call `getMidIndex(targetIndex = 1)`
    // and it will return a position that is in the middle of the range, and `position % data.size == 1`
    fun getMidIndex(targetIndex: Int): Int {
        val mid = getMidIndex()
        val leftover = mid % data.size
        val toCompleteOneSet = data.size - leftover
        val indexInLoop = mid + toCompleteOneSet + targetIndex
        //=> for example: indexInLoop = 1073741826, indexInLoop%data.size = 1
        return indexInLoop
    }

    override fun onViewAttachedToWindow(holder: RvViewHolder) {
        val position = holder.getAbsoluteAdapterPosition()
        val index = getIndexOf(position)
        if (data.size > index) {
            val datum = data[index]
            datum.onAttach(holder)
        }
    }

    // holder的absoluteAdapterPosition与bindingAdapterPosition, 经测试是一样的值, 都是45, 67, 88这样的
    // 是的, 在loopAdapter里, 它并不是0,1,2的范围, 而是很大的值
    override fun onViewDetachedFromWindow(holder: RvViewHolder) {
        println("szw rvHome detach : ${holder.absoluteAdapterPosition}")
        val position = holder.getAbsoluteAdapterPosition()
        val index = getIndexOf(position)
        if (data.size > index) {
            val datum = data[index]
            datum.onDetach(holder)
        }
    }

}