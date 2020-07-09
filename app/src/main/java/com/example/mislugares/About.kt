package com.example.mislugares

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Toast
import kotlinx.android.synthetic.main.about.*

class About : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about)

        /*
            Makes the text in a anchor tag clickable (when the text is not the actual link url).
            If the text is the url, just use android:autoLink
         */
        aboutTextView.movementMethod = LinkMovementMethod.getInstance()

        // Get extras provided by launcher activity
        val extras = intent.extras

        /*
        Get each variable provided by launcher activity
            - extras? => safe call to avoid null pointer exception if extras is null
            - ?: => Elvis operator: if first expression exists, returns the value; if it doesn't, returns value of second expression
         */
        val name = extras?.getString("name") ?: "no_name"
        val age = extras?.getInt("age") ?: -1

        // Launched activity can return data to launcher activity
        val intent = Intent()
        intent.putExtra("greeting", "Hello " + name + "!")
        setResult(Activity.RESULT_OK, intent)
    }
}
