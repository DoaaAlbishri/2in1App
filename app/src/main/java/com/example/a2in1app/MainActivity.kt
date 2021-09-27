package com.example.a2in1app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // var clMain = findViewById<ConstraintLayout>(R.id.clMain)
        var btn1 = findViewById<Button>(R.id.button)
        var btn2 = findViewById<Button>(R.id.button2)

        btn1.setOnClickListener {
            val intent = Intent(this, NumbersGame::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            val intent = Intent(this, GuessThePhrase::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m1 -> {
                val intent = Intent(this, NumbersGame::class.java)
                startActivity(intent)
                return true
            }
            R.id.m2 -> {
                val intent = Intent(this, GuessThePhrase::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}