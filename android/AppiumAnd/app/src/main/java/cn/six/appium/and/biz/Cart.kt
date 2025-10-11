package cn.six.appium.and.biz

object Cart {
    private val map = hashMapOf<String, Int>() // key = productId, value = countInCart
    private var snapshotStr: String? = null // 用字符串存储快照

    // 添加或修改商品数量
    fun updateItem(productId: String, count: Int) {
        if (count <= 0) {
            map.remove(productId)
        } else {
            map[productId] = count
        }
    }

    // 生成当前购物车的字符串快照（按key排序确保拼接顺序一致）
    private fun generateSnapshotString(): String {
        return map.entries
            .sortedBy { it.key } // 按商品ID排序，避免键值对顺序不同导致字符串不同
            .joinToString(separator = "|") { "${it.key}=${it.value}" }
    }

    // 保存当前状态为快照
    fun saveSnapshot() {
        snapshotStr = generateSnapshotString()
    }

    // 对比当前状态与快照是否有变化
    fun hasSnapshotChanged(): Boolean {
        val currentStr = generateSnapshotString()
        return snapshotStr != currentStr
    }
}

/*
1. 可能的snapshot功能: 用另一个map来存当前数据
object Cart {
    private val map = hashMapOf<String, Int>() // key = productId, value = countInCart
    private var snapshot: Map<String, Int>? = null // 用于存储快照

2. 不过为了打日志容易, 以及比较更容易, 我采用了string的方案
这时就要注意sort下, 这样才不会因为顺序不对而有问题
 */