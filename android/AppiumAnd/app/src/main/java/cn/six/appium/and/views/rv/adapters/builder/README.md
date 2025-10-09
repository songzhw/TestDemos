# I. BuilderAdapter's Example

## 1. Builder Item

```kotlin
class TitleItem(val title: String) : BuilderItem(title) {
    override fun getViewType() = R.layout.item_rv_one

    override fun render(holder: RvViewHolder) {
        holder.setText(R.id.tv_rv_item, title) // set text
    }

}
```


```kotlin
data class Description(val desp: String, val imageResId: Int)

class DescriptionItem(val despcription: Description) : BuilderItem(despcription) {
    override fun getViewType() = R.layout.item_desp

    override fun render(holder: RvViewHolder) {
        holder.setText(R.id.tvItem, despcription.desp)   // set text
        holder.setSrc(R.id.ivItem, despcription.imageResId) // set image
        holder.setClickListener(R.id.tvItem) {
            Toast.makeText(it.context, "click: ${despcription.desp}", Toast.LENGTH_SHORT).show()
        }
    }
}
```

## 2. Activity

```kotlin
class BuilderAdapterDemo : AppCompatActivity(R.layout.activity_rv) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rv.layoutManager = LinearLayoutManager(this)

        val wrapper = BuilderAdapterWrapper()

        wrapper.add(TitleItem("views"))
        wrapper.add(DescriptionItem(Description("scratch card", R.drawable.photo4)))
        wrapper.add(DescriptionItem(Description("jimu rv", R.drawable.photo5)))

        wrapper.add(TitleItem("recyclerviews"))
        wrapper.add(DescriptionItem(Description("folder view", R.drawable.food)))
        wrapper.add(DescriptionItem(Description("tiger", R.drawable.little_tiger)))

        wrapper.add(TitleItem("photos"))
        wrapper.add(DescriptionItem(Description("scope", R.drawable.photo1)))
        wrapper.add(DescriptionItem(Description("hill", R.drawable.photo2)))
        wrapper.add(DescriptionItem(Description("lake", R.drawable.photo3)))

        rv.adapter = wrapper.generateAdapter()

    }
}
```


# II. BuildLoopAdapter
It's almost 100% same as BuildAdapter.
The only difference is `BuildLoopAdapter` will be a infinite loop, especially useful for the carousel use case.
(example: the ViewPager carousel, such as HSB list in the home page, or the image/video top section in the new-design Offer Detail page)



# III. PageLifecycleDetectorInBuilderItem

There are four steps to enable your BuildItem to detect the Activity Lifecycle.

```kotlin
// 1. need BuildItem implement DefaultLifecycleObserver
class SomeBuildItem : BuilderItem, DefaultLifecycleObserver { 
    // 2. declare PageLifecycleDetectorInBuilderItem as a member
    private val pageLifecycle = PageLifecycleDetectorInBuilderItem()

    override fun getViewType(): Int = R.layout.item_text_detect

    override fun render(vh: RvViewHolder) {
        pageLifecycle.setup(vh, this)  // 3. call its setup method
        ...
    }

    // 4. declare your lifecyle method that you are interested in
    override fun onResume(owner: LifecycleOwner) {
        pageLifecycle.vhRef.get()?.setText(R.id.tvInfo, "onResume")
    }

}

```

p.s. please don't init such an instance inside the `render()` method, <br/> 
that would cause multiple lifecylce observer

p.s. to avoid memory leak, we use `WeakReference<RvViewHolder>` to host the instance of VH<br/>
when we need to use it, we call `pageLifecycle.vhRef.get()`

=> 这是一种组合的方式, 并不是继承的方式, 来达到了监听的目的

# IV. ViewHolder's lifecycle

## 1. OneAdapter
You can just override  `Adapter.onViewDetachedFromWindow`, `Adapter.onViewAttachedFromWindow `

```kotlin
        val adapter = object : OneAdapter<Sweets>(R.layout.item_builder_huge_title, data) {
            override fun apply(vh: RvViewHolder, value: Sweets, position: Int) {
                vh.setSrc(R.id.ivTitle, value.image)
                vh.setText(R.id.tvTitle, value.name)
                val bg = if(position % 2 == 0) Color.WHITE else Color.LTGRAY
                vh.setBackgroundColor(R.id.llayRoot, bg)
                vh.rootView<View>().setOnClickListener {
                    println("szww click rv.item($position) : $value")
                }
            }

            override fun onViewAttachedToWindow(holder: RvViewHolder) {
                val pos = holder.absoluteAdapterPosition
                if(pos == 0) println("szww @attach : hello")
            }

            override fun onViewDetachedFromWindow(holder: RvViewHolder) {
                val pos = holder.absoluteAdapterPosition
                if(pos == 0) println("szww #detach : hello")
            }
        }
```


## 2. BuilderItem
you can just override `BuildItem.onAttach(vh)`, `BuildItem.onDetach(vh)`

```kotlin
class IconTitleItem(val title: String, val iconResId: Int) : BuilderItem {
    override fun getViewType() = R.layout.item_builder_title
    override fun render(vh: RvViewHolder) {
        vh.setText(R.id.tvTitle2, title)
        vh.setSrc(R.id.ivTitle2, iconResId)
    }

    override fun onAttach(vh: RvViewHolder) {
        println("szww @attach : ${title}")
    }

    override fun onDetach(vh: RvViewHolder) {
        println("szww #detach : $title")
    }
}
```