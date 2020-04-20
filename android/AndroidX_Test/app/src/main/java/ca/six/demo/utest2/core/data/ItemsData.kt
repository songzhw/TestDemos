package ca.six.demo.utest2.core.data

import org.json.JSONObject

data class ItemData(val src: JSONObject) {
    val id: String
    val name: String
    val image: String

    init {
        id = src.optString("id")
        name = src.optString("id")
        image = src.optString("img")
    }
}

data class ItemsData(val src: String) {
    var isContinue = false
    val items = ArrayList<ItemData>()

    init {
        val json = JSONObject(src)
        isContinue = json.optBoolean("continue")
        val ary = json.optJSONArray("items")
        for (i in 0 until ary.length()) {
            val item = ItemData(ary.get(i) as JSONObject)
            items.add(item)
        }
    }
}