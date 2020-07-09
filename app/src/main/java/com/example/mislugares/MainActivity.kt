package com.example.mislugares

// Very important to always extend from AppCompatActivity, provides latest GUI elements independent from API development version
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

//class MainActivity : AppCompatActivity(), View.OnLongClickListener{
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(
                view,
                "Replace with your own action",
                Snackbar.LENGTH_LONG).setAction("Action", null).show()
        }

        /***************************
         **** Event Listeners ******
         ***************************
         *
         * We can add event listeners in different ways:
         *
         * 1. We can set the "onClick" event listener for a view in its xml and just implement the handler.
         *
         * 2. For other events, we can extend from the specific listener class, then set the listener and finally override the specific handler
         * This is showed in this class with the onLongClick event:
         * - Extend from View.OnLongClickListener
         * - Set the listener: aboutButton.setOnLongClickListener(this)
         * - Implement the function override fun onLongClick(v: View?): Boolean
         *
         * 3. A third way, implement the handler in one go aboutButton.setOnTouchListener { view -> ...}
         *
         * More info here: https://developer.android.com/guide/topics/ui/ui-events#kotlin
         */

        // Register the onLongClick event on the aboutButton and implements View.OnLongClickListener by overriding onLongClick below
        //aboutButton.setOnLongClickListener(this)

        // Handles the onTouch event on the aboutButton
        /*
        aboutButton.setOnTouchListener(
            fun(view: View?, _: MotionEvent?): Boolean {
                Toast.makeText(this, getToastText("Touch", view), Toast.LENGTH_SHORT).show()
                return false
            }
        )
        */

        exitButton.setOnClickListener{
            exit(it)
        }

    }

    /*
    override fun onLongClick(view: View?): Boolean {
        Toast.makeText(this, getToastText("Long Click", view), Toast.LENGTH_SHORT).show()
        return false
    }
    */

    // Handles the onClick event on the aboutButton
    fun aboutClicked(view: View? = null){

        // Create an intent in order to start a new activity
        val intent = Intent(this, About::class.java)

        // Create some extras and pass data to new activity
        //intent.putExtra("name", "John Smith")
        //intent.putExtra("age", 27)

        // Launch new About activity not expecting any data to be returned
        startActivity(intent)

        // Launch new About activity expecting data to be returned
        // Some id is required to identify launcher activity when data is returned from launched activity
        //startActivityForResult(intent, ABOUT_INTENT_ID)
    }

    private fun exit(view: View) {
        finish()
    }

    // Get some text using the name of the view.
    // But first, get the name of the View v providing its id.
    // Can the View v be null?...probably not...
    // But just for the sake of learning, check that v is not null and we can get its id.
    /*
    private fun getToastText(eventName: String, v: View?): String {
        v?.id?.let{
            return  eventName + " detected for " + resources.getResourceEntryName(it)
        } ?:
        return "View does not exist"
    }
    */

    /*
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ABOUT_INTENT_ID && resultCode == Activity.RESULT_OK) {
            val greeting = data?.extras?.getString("greeting") ?: "error"
            Toast.makeText(this, greeting, Toast.LENGTH_SHORT).show()
        }
    }
    */

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /* Handle action bar item clicks here.
        * The action bar will automatically handle clicks on the Home/Up button, so long you specify a parent activity in AndroidManifest.xml.
        */

        /* This is basically just a switch statement which must return a Boolean value.
        * Catches clicks on each menu item and performs some action.
        */
        return when (item.itemId) {
            R.id.settingsMenuOption -> {
                Toast.makeText(this, "He pulsado Settings", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.aboutMenuOption -> {
                // Trigger click event programatically in a view (everything inherits from View)
                aboutButton.performClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}






