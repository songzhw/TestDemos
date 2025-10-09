# 一. builder
类似积木的形式来搭配RV
或者说类似`scrollView.addChildView(child)`的形式

# 二. one
OneAdapter就是不用自己写Adapter了, 它生成的就是 Rv.Adapter

# 三. onelist
OneListAdapter类似OneAdapter, 但它生成的是 ListAdapter,
它与DiffUtil相组合, 方便了后续更新数据, 即不用手动调用notifyItemXXX(),
直接用adapter.submitList(data)即可

## 3.1 坑
注意: 每次submitList的参数, 得是一个另一个List对象.
不能是上一个list对象的remove, add之后. 要么是一个新list对象, 要么是原list对象的深拷贝(不能是浅拷贝)

## 3.2 例子

```kotlin
    val food = arrayListOf(
    Food(11, "壽司"), Food(12, "天ぷら"), Food(13, "すき焼き"),
    Food(14, "ラーメン"), Food(15, "カレーライス"), Food(16, "とんかつ"),
)

val adapter = object: OneListAdapter<Food>(R.layout.item_simple_texts, Food.diff){
    override fun apply(holder: RvViewHolder, value: Food, position: Int) {
        holder.setText(R.id.tvTitle, value.id.toString())
        holder.setText(R.id.tv1, value.name)
    }
}
adapter.submitList(food)
rv.adapter = adapter
rv.layoutManager = LinearLayoutManager(this)

// 修改数据后再刷新rv
val list = food.map { it.clone() } as ArrayList<Food> // 这行就是为了clone一个新对象出来
list.removeAt(3) //这一行也可以是add(newObj)等....
adapter.submitList(list)

```


# 四. Builder + DiffUtil
这就是要结合Builder与DiffUtil的双双好处了. 当然为了能提供diff的依据, 我们也要给每个BuildItem提供isSame等算法,
所以整体上, 使用起来更复杂了. 但这是为了性能没有的办法.

## 4.1 usage

### 4.1.1 step 1: 修改BuildItem
BuildItem这个基类不用变化, 但每个其子类要添加一个static的 fun isSame(old, now): MatchEachDiffResult的方法了

```kotlin
class InvisibleDividerItem: BuildItem {
    override fun getViewType(): Int = R.layout.item_invisible_divider
    override fun render(holder: RvViewHolder) { ... }
    
    // 下面就是新内容了
    companion object {
        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            if (old is InvisibleDividerItem && now is InvisibleDividerItem) {
                if (old.size == now.size) return MatchEachDiffResult.MATCHED_TRUE
                else return MatchEachDiffResult.MATCHED_FALSE
            }
            return MatchEachDiffResult.NOT_MATCHED
        }
    }
}
```

另一个例子:

```kotlin
class OfferInGridItem: BuildItem {
    override fun getViewType(): Int = R.layout.item_invisible_divider
    override fun render(holder: RvViewHolder) { ... }
    
    // 下面就是要新加的部分
    companion object {
        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            if (old is OfferInGridItem && now is OfferInGridItem) {
                if (old.offers.size != now.offers.size) MatchEachDiffResult.MATCHED_FALSE
                val isSameContent = old.offers.zip(now.offers).all { (e1, e2) ->
                    e1.static.offerId == e2.static.offerId && e1.dynamic.claimsRemaining == e2.dynamic.claimsRemaining
                            && e1.dynamic.maxClaims == e2.dynamic.maxClaims
                }
                return if (isSameContent) MatchEachDiffResult.MATCHED_TRUE else MatchEachDiffResult.MATCHED_FALSE
            }
            return MatchEachDiffResult.NOT_MATCHED
        }
    } 
```

## 4.1.2 汇总这些isSame函数, 发给Adapter

```kotlin
    private var adapter: ListAdapter<BuilderItem, RvViewHolder>? = null

    val diff = DiffBuilderCallback(arrayListOf(
        FeaturedBuildItem::isSame, FullBleedHeroItem::isSame,
        InvisibleDividerItem::isSame, SectionTitleRvItem::isSame,
        OfferInGridItem::isSame, OfferInListItem::isSame,
    ))

    if(adapter == null) {
        println("szw new adapter")
        adapter = wrapper.generateDiffAdapter(diff)
        rvHome.adapter = adapter
        rvHome.layoutManager = LinearLayoutManager(this)
    }
    
```

### 4.1.3 把积木们(BuilderItem)给adapter提交

```kotlin
val wrapper = BuilderAdapterWrapper()
wrapper.add(SectionTitleRvItem("Featured", batch.featureOffers.count()))
wrapper.add(FeaturedBuildItem(batch.featureOffers))
wrapper.add(InvisibleDividerItem(Size(1, 8)))
adapter!!.submitList(wrapper.list)
```

### 4.1.4 完整例子:
```kotlin
private var adapter: ListAdapter<BuilderItem, RvViewHolder>? = null

// 使用Builder来搭积木
val wrapper = BuilderAdapterWrapper()
wrapper.add(FullBleedHeroItem(batch.hsb, this.lifecycle, this::swapListRenderer))
wrapper.add(SectionTitleRvItem("Featured", batch.featureOffers.count()))
wrapper.add(FeaturedBuildItem(batch.featureOffers))
wrapper.add(InvisibleDividerItem(Size(1, 8)))

val diff = DiffBuilderCallback(arrayListOf(
    FeaturedBuildItem::isSame, FullBleedHeroItem::isSame,
    InvisibleDividerItem::isSame, SectionTitleRvItem::isSame,
    OfferInGridItem::isSame, OfferInListItem::isSame,
))
if(adapter == null) {
    adapter = wrapper.generateDiffAdapter(diff)
    rvHome.adapter = adapter
    rvHome.layoutManager = LinearLayoutManager(this)
}

adapter!!.submitList(wrapper.list)
```

### 4.1.5 注意1
当我在Redeem页, 只有star数目(clip了几次)才会变化时, 我用的是:
```kotlin
    companion object : KoinComponent {
        private val starMapS: StarMap by inject()

        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            var ret = MatchEachDiffResult.NOT_MATCHED
            if (old is RedeemCashbackOfferItem && now is RedeemCashbackOfferItem) {
                val prev = old.offer.static.offerId
                val next = now.offer.static.offerId
                if (prev == next && starMapS.get(prev) == starMapS.get(next))
                    ret = MatchEachDiffResult.MATCHED_TRUE
                else ret = MatchEachDiffResult.MATCHED_FALSE
            }
            println("szww offer.isSame = $ret")
            return ret
        }

    }
```

这样无论star数目如何变化, 在`adapter?.submitList(newBuildItemList)`后都不会刷新
我试了, 参数newBuildItemList是新的对象, 所以肯定不是老数据的问题, 问题肯定出在了isSame这里.


其实原因就是StarMap是全局的, 等要isSame()执行时, 你上面的prevOfferId, nextOfferId其实是一样的情况下, starMap[id]得出来的count是一样的
所以才返回了MATCHED_TRUE


### 4.1.6 注意2
```kotlin
    companion object : KoinComponent {
        private val starMapS: StarMap by inject()
        private val prevMap = HashMap(starMapS.map) //<== new line

        fun isSame(old: BuilderItem, now: BuilderItem): MatchEachDiffResult {
            var ret = MatchEachDiffResult.NOT_MATCHED
            if (old is RedeemCashbackOfferItem && now is RedeemCashbackOfferItem) {
                val prev = old.offer.static.offerId
                val next = now.offer.static.offerId
                if (prev == next && starMapS.getPrev(prev) == starMapS.get(next))
                    ret = MatchEachDiffResult.MATCHED_TRUE
                else ret = MatchEachDiffResult.MATCHED_FALSE
                prevMap.clear()              //<== new line
                prevMap.putAll(starMapS.map) //<== new line
            }
            println("szww offer.isSame = $ret")
            return ret
        }

    }
```

这样仍不行. 因为一个rv里若有10个item, 那isSame会被触发10次以上, 这样第一次2个item刚比较完, prevMap就和map一样了,
那还有9次或更多次的isSame再比较就发现prevMap和map一样了, 这样就容易明明应该返回false, 却返回了true

**解决办法:** 把prevMap放到starMap里去哦, 这样才是全局的prevMap!!!


### 4.1.7 注意3
另一个要注意的跟DiffUtils无直接相关, 但跟starMap中的prevMap有关, 可以见:
```kotlin
        // [重要说明]:
        // 光更新一个id不行的, 因为若前后更新两个offer的数目, 那原来是{a:1, b:1}
        // 现在我们得到的是 map = {a:2, b:1} , prev = {a:1, b:1}, 所以a变了
        // 之后就是 map = {a:2, b:2}, prev = {a:1, b:1}, 所以a, b都变化了 (但这时明明只有b变了, a没变)
        // 所以下面这行是不行的, 得copy整个map到prevMap里来

        // 出错的代码
        // -> -> [buggy] prevMap[id] = map[id] ?: 0

        // fix后的代码: 
        prevMap.clear()
        map.forEach { (k, v) -> prevMap[k] = v }
```


## 4.2 改进
这个isSame的方法, 其实可以用 LiveTemplate来简化, 让程序员更方便