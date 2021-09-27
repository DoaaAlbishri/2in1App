package com.example.a2in1app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class GuessThePhrase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guess)
        var myLayout = findViewById<ConstraintLayout>(R.id.clMain)
        val tv1 = findViewById<TextView>(R.id.tv)
        val tv2 = findViewById<TextView>(R.id.tv1)
        val tv3 = findViewById<TextView>(R.id.tv2)
        val tv4 = findViewById<TextView>(R.id.tv3)
        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)


        var pharse = "Hello World"
        var str = "*".repeat(pharse.length)
        var Newstr = str
        var left = 10
        var letter = 10

        tv1.setText("Pharse: ${str} \n Gussed Letter: ")

        button.setOnClickListener {
            if (left > 0) {
                var input = editText.text.toString()
                if (!editText.text.isEmpty()) {
                    if (pharse.toLowerCase() == input.toLowerCase()) {
                        --left
                        tv1.setText("Pharse: ${input} \n Gussed Letter: ")
                        tv4.setText("${left} guesses remaining")
                        this.recreate()
                    } else {
                        --left
                        tv2.setText("Wrong guess : ${input}")
                        tv4.setText("${left} guesses remaining")
                    }
                }
                if(left==0){
                    editText.hint = "Gusses the letter"
                }
            }
            else if (letter>0 && left<=0){
                editText.hint = "Gusses the letter"
                var input:Char = editText.text.toString()[0]
                var count = 0
                if (!editText.text.isEmpty()&&editText.text.length==1) {
                    letter--
                    for (i in 0..pharse.length - 1) {
                        if (pharse[i].toLowerCase().equals(input.toLowerCase())) {
                            var chars =Newstr.toCharArray()
                            chars[i]=input
                            Newstr = String(chars)
                            // Newstr = Newstr.replace(Newstr[i], input)
                            count++
                        }
                        if(pharse[i] == ' '){
                            var chars =Newstr.toCharArray()
                            chars[i]=' '
                            Newstr = String(chars)
                        }
                    }
                    if(count>0){
                        tv1.setText("Pharse: ${Newstr} \n Gussed Letter: ${input} ")
                        tv2.setText("Wrong guess : ")
                        tv3.setText("Founds: ${count} ${input.toUpperCase()}(s)")
                        tv4.setText("${letter} guesses remaining")
                    } else {
                        tv2.setText("Wrong guess : ${input}")
                        tv4.setText("${letter} guesses remaining")
                    }
                }else{
                    Snackbar.make(myLayout,"Enter one letter please", Snackbar.LENGTH_LONG).show()
                }
                if(Newstr.equals(pharse,true)||letter==0){
                    this.recreate()
                }
            }
            editText.text.clear()

        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menus, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val item: MenuItem = menu!!.getItem(0)
        item.title="New Game"
        val item2: MenuItem = menu!!.getItem(1)
        item2.title="Numbers Game"
        val item3: MenuItem = menu!!.getItem(2)
        item3.setVisible(true)
        return super.onPrepareOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.m1 -> {
                //    val intent = Intent(this, GuessThePhrase::class.java)
                //    startActivity(intent)
                this.recreate()
                return true
            }
            R.id.m2 -> {
                val intent = Intent(this, NumbersGame::class.java)
                startActivity(intent)
                return true
            }
            R.id.m3 -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}