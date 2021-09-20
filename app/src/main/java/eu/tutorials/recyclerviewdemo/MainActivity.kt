package eu.tutorials.recyclerviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import eu.tutorials.recyclerviewdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val LIST_VIEW = "LIST_VIEW" // Value for List View
    val GRID_VIEW = "GRID_VIEW" // Value for Grid View

    //create a binding variable for its layout
    private var binding:ActivityMainBinding? = null
    var currentVisibleView: String =
        LIST_VIEW // Variable is used check which is current view visible as default it is list view.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //inflate the layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        //Attach the layout to this activity
        setContentView(binding?.root)
        setSupportActionBar(binding?.toolbar)

        listView()

        binding?.fabSwitch?.setOnClickListener { view ->

            if (currentVisibleView == LIST_VIEW) {
                binding?.fabSwitch?.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@MainActivity,
                        R.drawable.ic_list
                    )
                )
                gridView()
            } else {
                binding?.fabSwitch?.setImageDrawable(
                    ContextCompat.getDrawable(
                        this@MainActivity,
                        R.drawable.ic_grid
                    )
                )
                listView()
            }
        }
    }

    /**
     * Function is used to show the items in a list format
     */
    private fun listView() {

        currentVisibleView = LIST_VIEW // Current view is updated

        // Set the LayoutManager that this RecyclerView will use.
        binding?.rvItemsList?.layoutManager = LinearLayoutManager(this)
        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = ItemAdapter(getItemsList())
        // adapter instance is set to the recyclerview to inflate the items.
       binding?.rvItemsList?.adapter = itemAdapter
    }

    /**
     * Function is used to show the items in a grid format
     */
    private fun gridView() {

        currentVisibleView = GRID_VIEW // Current view is updated

        // Set the LayoutManager that this RecyclerView will use.
        binding?.rvItemsList?.layoutManager = GridLayoutManager(this, 2)
        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = ItemAdapter(getItemsList())
        // adapter instance is set to the recyclerview to inflate the items.
        binding?.rvItemsList?.adapter = itemAdapter
    }

    /**
     * Function is used to get the Items List which is added in the list.
     */
    private fun getItemsList(): ArrayList<String> {
        val list = ArrayList<String>()

        list.add("Item One")
        list.add("Item Two")
        list.add("Item Three")
        list.add("Item Four")
        list.add("Item Five")
        list.add("Item Six")
        list.add("Item Seven")
        list.add("Item Eight")
        list.add("Item Nine")
        list.add("Item Ten")
        list.add("Item Eleven")
        list.add("Item Twelve")

        return list
    }
}