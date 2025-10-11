package cn.six.appium.and.views.rv.adapters.builder_diff

import androidx.recyclerview.widget.DiffUtil
import cn.six.appium.and.views.rv.adapters.builder.BuilderItem

typealias CompareBuilderItemFunc = (BuilderItem, BuilderItem) -> MatchEachDiffResult

class DiffBuilderCallback(val parts: ArrayList<CompareBuilderItemFunc>) :
    DiffUtil.ItemCallback<BuilderItem>() {

    override fun areItemsTheSame(oldItem: BuilderItem, newItem: BuilderItem): Boolean {
        for (i in 0 until parts.size) {
            val result = parts[i](oldItem, newItem)
            if (result == MatchEachDiffResult.MATCHED_TRUE) return true
            else if (result == MatchEachDiffResult.MATCHED_FALSE) return false
            // else if(result == NOT_MATCHED) continue
        }
        return false
    }

    override fun areContentsTheSame(oldItem: BuilderItem, newItem: BuilderItem): Boolean {
        for (i in 0 until parts.size) {
            val result = parts[i](oldItem, newItem)
            if (result == MatchEachDiffResult.MATCHED_TRUE) return true
            else if (result == MatchEachDiffResult.MATCHED_FALSE) return false
            // else if(result == NOT_MATCHED) continue
        }
        return false
    }

    override fun getChangePayload(oldItem: BuilderItem, newItem: BuilderItem): Any? {
        return super.getChangePayload(oldItem, newItem)
    }
}
/*
1). 以购物车为例, RecyclerView的每个Item是一个 Goods 时,
* areItemsTheSame(old, new): 是比较多个item是否是同一实体. 一般基于ID.
    一般用于比较rv是否有新加或删除元素, 来决定是否要调用 onItemAdd, onItemRemove
* areContentTheSame(old, new): 这是说当areItemsTheSame返回true时, 这时比较下本item的内容有没有变化
    一般是用于检测某一item是否有变化(如是否勾选了), 来决定是否要notifyItemChanged

2). getChangePayload(old, new)是有什么用呢?
: 当areItemsTheSame返回true, 而areContentTheSame返回false时, 那RV知道这一项是要调用notifyItemChanged
但关于这个change了什么, 在一些场景你不用管用super即可(即返回null);
但一些场景你想定制, 这时说法可以返回一个payload (类型为任意Object), 这样你在 onBindVH(vh, position, paylodas)中可以用这个paylods
比如说你在onBindVH里看payload.contains("xx")就知道有购物车数字变化, 那就做一个数字的变化的动画
即可以更加精确地做小颗粒的刷新/动画
 */