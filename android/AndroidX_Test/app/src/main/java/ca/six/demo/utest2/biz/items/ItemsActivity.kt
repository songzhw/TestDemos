package ca.six.demo.utest2.biz.items

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ca.six.advk.utils.rv.OneAdapter
import ca.six.advk.utils.rv.RvViewHolder
import ca.six.advk.utils.rv.setSrc
import ca.six.demo.utest2.R
import ca.six.demo.utest2.core.data.ItemData
import ca.six.demo.utest2.ui.rv.OnRvItemClickListener
import kotlinx.android.synthetic.main.activity_items.*
import kotlinx.coroutines.launch

class ItemsActivity : AppCompatActivity(R.layout.activity_items) {
    lateinit var vm: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this).get(ItemsViewModel::class.java)

        lifecycleScope.launch {
            val items = vm.start()
            val adapter = object : OneAdapter<ItemData>(R.layout.item_items_list, items) {
                override fun apply(vh: RvViewHolder, value: ItemData, position: Int) {
                    vh.setText(R.id.tvItemItems, value.name)
                    vh.setSrc(R.id.ivItemItems, value.image)
                }
            }
            rvItems.layoutManager = LinearLayoutManager(this@ItemsActivity)
            rvItems.adapter = adapter

            rvItems.addOnItemTouchListener(object : OnRvItemClickListener(rvItems) {
                override fun onItemClick(vh: RecyclerView.ViewHolder) {
                    val index = vh.layoutPosition
                    val item = items[index]
                    println("szw $item")
                }
            })
        }
    }
}

