package cn.six.appium.and

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cn.six.appium.and.biz.Cart
import cn.six.appium.and.core.BasePage
import cn.six.appium.and.databinding.AfHomeBinding
import cn.six.appium.and.ext.dpToPx
import cn.six.appium.and.ext.nav
import cn.six.appium.and.views.rv.adapters.RvViewHolder
import cn.six.appium.and.views.rv.adapters.builder.BuilderAdapterWrapper
import cn.six.appium.and.views.rv.adapters.builder.BuilderItem

// 有多个页, 有img, 有button, 有editText, 有drawer,
// 有recyclerView (查找某item; 要滑动才能找到某item),
class HomePage : BasePage() {
    private lateinit var vb: AfHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = AfHomeBinding.inflate(layoutInflater)
        setContentView(vb.root)
    }

    override fun onResume() {
        super.onResume()
        // 用DiffUtil当然性能列好, 但这里为了简便就先不用了
        commonAndTitleVerticalLayout(vb.rvHome)
    }
}


fun commonAndTitleVerticalLayout(rv: RecyclerView) {
    val context = rv.context
    rv.layoutManager = LinearLayoutManager(context)
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
    rv.adapter = wrapper.generateAdapter()
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
            Cart.map.put(title, Cart.map.getOrDefault(title, 0) + 1)
            updateCount(vh)
        }
        vh.setClickListener(R.id.ivRemove) {
            val count = Cart.map.getOrDefault(title, 0)
            if (count > 1) {
                Cart.map.put(title, count - 1)
            } else if (count == 1) {
                Cart.map.remove(title)
            }
            updateCount(vh)
        }
    }

    private fun updateCount(vh: RvViewHolder) {
        val count = Cart.map.getOrDefault(title, 0)
        val visible = if(count <= 0) View.GONE else View.VISIBLE
        println("szww item = ${title}, count = $count")
        vh.setVisibility(R.id.tvCount, visible)
        vh.setText(R.id.tvCount, count.toString())
    }
}


data class TitleBuilderItem(val data: TitleDataForGroup) : BuilderItem {
    override fun getViewType() = R.layout.item_builder_title
    override fun render(vh: RvViewHolder) {
        vh.setText(R.id.tvTitle2, data.title)
        vh.setSrc(R.id.ivTitle2, data.imageResId)
        vh.getView<View>(R.id.llayRoot).setTag(R.layout.item_builder_title, data)
    }
}

data class DividerBuilderItem(val heightInDp: Int) : BuilderItem {
    override fun getViewType() = R.layout.item_builder_divider
    override fun render(vh: RvViewHolder) {
        vh.getView<View>(R.id.viewDivider).updateLayoutParams {
            height = heightInDp.dpToPx()
        }
    }
}

data class TitleDataForGroup(val imageResId: Int, val title: String)
