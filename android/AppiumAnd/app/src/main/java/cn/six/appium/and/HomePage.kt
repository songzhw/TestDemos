package cn.six.appium.and

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import cn.six.appium.and.biz.Cart
import cn.six.appium.and.core.BasePage
import cn.six.appium.and.databinding.AfHomeBinding
import cn.six.appium.and.ext.dpToPx
import cn.six.appium.and.ext.nav
import cn.six.appium.and.views.rv.adapters.RvViewHolder
import cn.six.appium.and.views.rv.adapters.builder.BuilderAdapterWrapper
import cn.six.appium.and.views.rv.adapters.builder.BuilderItem
import cn.six.appium.and.views.rv.adapters.builder_diff.DiffBuilderCallback
import cn.six.appium.and.views.rv.adapters.builder_diff.MatchEachDiffResult

// 1. 若adapter不是成员, 那就会有问题:
//  : 刷新是有刷新  (DiffUtil + ListAdapter), 但刷新后总是回到rv第0项的位置
//    原因是rv每次都用新的adapter, 那自然就会认为整个rv都刷新了, 所以刷新后就重新到了第0项
//    解决之法就是用一个adapter成员, 这样之后的adapter.submitList()就不会刷新rv
class HomePage : BasePage() {
    private lateinit var vb: AfHomeBinding
    private lateinit var adapter: ListAdapter<BuilderItem, RvViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = AfHomeBinding.inflate(layoutInflater)
        setContentView(vb.root)

        val context = vb.rvHome.context
        vb.rvHome.layoutManager = LinearLayoutManager(context)
        val wrapper = assembleBuildItemList()
        val diff = DiffBuilderCallback(
            arrayListOf(
                ShowcaseItem.Companion::isSame,
                TitleBuilderItem.Companion::isSame,
                DividerBuilderItem.Companion::isSame
            )
        )
        adapter = wrapper.generateDiffAdapter(diff)
        vb.rvHome.adapter = adapter
        adapter.submitList(wrapper.list)

    }

    override fun onResume() {
        super.onResume()
        // 用DiffUtil当然性能列好, 但这里为了简便就先不用了
        refresh(adapter)
    }

}


fun refresh(adapter: ListAdapter<BuilderItem, RvViewHolder>) {
    val wrapper = assembleBuildItemList()
    adapter.submitList(wrapper.list)
}

private fun assembleBuildItemList(): BuilderAdapterWrapper {
    val wrapper = BuilderAdapterWrapper()
    wrapper.add(TitleBuilderItem(TitleDataForGroup(R.mipmap.ic_launcher, "风景")))
    wrapper.add(ShowcaseItem("apple", R.drawable.ic_apple))
    wrapper.add(ShowcaseItem("banana", R.drawable.ic_banana))
    wrapper.add(ShowcaseItem("cherry", R.drawable.ic_cherry))
    wrapper.add(TitleBuilderItem(TitleDataForGroup(R.mipmap.ic_launcher, "自然")))
    wrapper.add(ShowcaseItem("durian", R.drawable.ic_durian))
    wrapper.add(ShowcaseItem("eggplant", R.drawable.ic_eggplant))
    wrapper.add(TitleBuilderItem(TitleDataForGroup(R.mipmap.ic_launcher, "东瀛")))
    wrapper.add(ShowcaseItem("fig", R.drawable.ic_fig))
    wrapper.add(ShowcaseItem("grape", R.drawable.ic_grape))
    wrapper.add(DividerBuilderItem(100))
    return wrapper
}

class ShowcaseItem(val title: String, val imageResId: Int) : BuilderItem {
    override fun getViewType(): Int = R.layout.item_builder_showcase
    override fun render(vh: RvViewHolder) {
        vh.setSrc(R.id.ivProduct, imageResId)
        vh.setText(R.id.tvInfo, title)
        vh.rootView<View>().setOnClickListener {
            val actv = it.context as? Activity ?: return@setOnClickListener
            actv.nav<DetailPage>(bundleOf("title" to title, "img" to imageResId))
        }

        updateCount(vh)

        vh.setClickListener(R.id.ivAdd) {
            Cart.increase(title)
            updateCount(vh)
        }
        vh.setClickListener(R.id.ivRemove) {
            Cart.decrease(title)
            updateCount(vh)
        }
    }

    private fun updateCount(vh: RvViewHolder) {
        val count = Cart.map.getOrDefault(title, 0)
        val visible = if (count <= 0) View.GONE else View.VISIBLE
        vh.setVisibility(R.id.tvCount, visible)
        vh.setText(R.id.tvCount, count.toString())
    }

    companion object {
        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            if (old is ShowcaseItem && now is ShowcaseItem) {
                val isCountChanged = Cart.isItemChanged(now.title)
                val isMatch = (old.title == now.title) && (!isCountChanged)
                if (isMatch) return MatchEachDiffResult.MATCHED_TRUE
                else return MatchEachDiffResult.MATCHED_FALSE
            }
            return MatchEachDiffResult.NOT_MATCHED
        }
    }
}


data class TitleBuilderItem(val data: TitleDataForGroup) : BuilderItem {
    override fun getViewType() = R.layout.item_builder_title
    override fun render(vh: RvViewHolder) {
        vh.setText(R.id.tvTitle2, data.title)
        vh.setSrc(R.id.ivTitle2, data.imageResId)
        vh.getView<View>(R.id.llayRoot).setTag(R.layout.item_builder_title, data)
    }

    companion object {
        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            if (old is TitleBuilderItem && now is TitleBuilderItem) {
                if (old.data.title == now.data.title) return MatchEachDiffResult.MATCHED_TRUE
                else return MatchEachDiffResult.MATCHED_FALSE
            }
            return MatchEachDiffResult.NOT_MATCHED
        }
    }
}

data class DividerBuilderItem(val heightInDp: Int) : BuilderItem {
    override fun getViewType() = R.layout.item_builder_divider
    override fun render(vh: RvViewHolder) {
        vh.getView<View>(R.id.viewDivider).updateLayoutParams {
            height = heightInDp.dpToPx()
        }
    }

    companion object {
        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            if (old is DividerBuilderItem && now is DividerBuilderItem) {
                if (old.heightInDp == now.heightInDp) return MatchEachDiffResult.MATCHED_TRUE
                else return MatchEachDiffResult.MATCHED_FALSE
            }
            return MatchEachDiffResult.NOT_MATCHED
        }
    }
}

data class TitleDataForGroup(val imageResId: Int, val title: String)
