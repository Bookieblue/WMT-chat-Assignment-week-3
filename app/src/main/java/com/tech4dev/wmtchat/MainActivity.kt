package com.tech4dev.wmtchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tech4dev.wmtchat.adapter.MainPageAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tab)

        viewPager = findViewById(R.id.viewPager)
        viewPager.adapter = MainPageAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager){ tab, position ->
            when(position){
                0 -> tab.icon = getDrawable(R.drawable.ic_baseline_photo_camera_24)
                1 -> tab.text ="Chat"
                2 -> tab.text ="Status"
                3 -> tab.text ="Calls"
            }
        }.attach()

        viewPager.currentItem = 1
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.app_bar_search -> {
                Toast.makeText(this, "Search click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_group ->{
                goToNewGroupActivity()
                return true
            }
            R.id.new_broadcast ->{
                goToEmptyActivity()
                //Toast.makeText(this, "New Broadcast click", Toast.LENGTH_LONG).show()
                return true

            }
            R.id.linked_devices -> {
                Toast.makeText(this, "Linked Devices click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.settings ->{
                Toast.makeText(this, "Settings click", Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                return false
            }
        }
    }

    private fun goToNewGroupActivity(){
        val i = Intent(this, NewGroupActivity::class.java)
        startActivity(i)
    }
    private fun goToEmptyActivity(){
        val intent = Intent(this, BroadcastMenuActivity::class.java)
        startActivity(intent)
    }
}