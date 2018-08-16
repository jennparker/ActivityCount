package com.booisajerk.activitycount

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.*
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*
import android.widget.TextView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var countInt: Int = 0
    var defaultRandomMax = 20

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

//        fab.setOnClickListener { view ->
//            Snackbar.make(view, "Not sure if I'll use this or not", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null).show()
//        }

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                showAlertDialog()
            }
            R.id.nav_workout_history -> {
                val intent = Intent(this, WorkoutHistory::class.java)
                startActivity(intent)
            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun addSquatCount(view: View) {
        //get the current count
        var currentCount = squatCount.text.toString()
        println("Squat count $currentCount")

        //convert to int and increment
        countInt = currentCount.toInt()
        countInt++

        //display new value
        squatCount.setText(countInt.toString())
    }

    fun addPushUpCount(view: View) {
        //get the current count
        var currentCount = pushUpCount.text.toString()
        println("Push up count $currentCount")

        //convert to int and increment
        countInt = currentCount.toInt()
        countInt++

        //display new value
        pushUpCount.setText(countInt.toString())
    }

    fun addDipCount(view: View) {
        //get the current count
        var currentCount = dipCount.text.toString()
        println("Dip count $currentCount")

        //convert to int and increment
        countInt = currentCount.toInt()
        countInt++

        //display new value
        dipCount.setText(countInt.toString())
    }

    fun showAlertDialog() {
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setMessage(getRandomNumber().toString())
        val title = TextView(this)
        title.setText(R.string.random)
        title.setPadding(10, 10, 10, 10)
        title.gravity = Gravity.CENTER
        title.textSize = 20F
        alertDialog.setCustomTitle(title)

        alertDialog.show()

        val message = alertDialog.findViewById<TextView>(android.R.id.message)
        message.gravity = Gravity.CENTER
        message.textSize = 65F
    }

    fun getRandomNumber(): Int {
        //get the count from the intent
        //  val intent: Intent = Intent.getIntent("randomIntent")
        // val count = intent.getIntExtra(TOTAL_COUNT,0)

        //generate the random number
        val random = Random()
        var randomInt = 0

        if (defaultRandomMax > 0) {
            randomInt = random.nextInt(defaultRandomMax + 1)
        }

        //display the random number
//        randomNumber.text = Integer.toString(randomInt)
//        randomHeading.text = getString(R.string.random_generator_text, count)
        return randomInt
    }
}
