package dev.thebigbot.maath

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var num1: Number = 0
    var num2: Number = 0
    var op: Number = 0 // 1 = +; 2 = -; 3 = *; 4 = /;
    var res = 0;
    var welcome = true;

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove action bar
        supportActionBar?.hide()

        // Widget
        val btn_yes: Button = findViewById(R.id.btn_yes)
        val btn_no: Button = findViewById(R.id.btn_no)
        val text: TextView = findViewById(R.id.opText)
        val score_text: TextView = findViewById(R.id.scoreText)
        val new_game: Button = findViewById(R.id.newGame)

        new_game.visibility = View.INVISIBLE

        btn_yes.setOnClickListener {
            onYesPress(it, text, score_text, new_game, btn_no)
        }

        btn_no.setOnClickListener {
            onNoPress(it, text, score_text, new_game, btn_yes)
        }

        new_game.setOnClickListener {
            onNewGamePress(it, text, score_text, new_game, btn_yes, btn_no)
        }
    }

    fun onYesPress(it: View, text: TextView, score_text: TextView, new_game: Button, btn: Button) {
        if (welcome) {
            generateExpression()

            when (op) {
                1 -> {
                    text.setText("$num1 + $num2 = $res")
                }

                2 -> {
                    text.setText("$num1 - $num2 = $res")
                }

                3 -> {
                    text.setText("$num1 * $num2 = $res")
                }

                4 -> {
                    text.setText("$num1 / $num2 = $res")
                }
            }

            welcome = false
            return;
        }

        if (!welcome) {
            var true_res = 0;

            when (op) {
                1 -> {
                    true_res = num1 as Int + num2 as Int
                }

                2 -> {
                    true_res = num1 as Int - num2 as Int
                }

                3 -> {
                    true_res = num1 as Int * num2 as Int
                }

                4 -> {
                    true_res = num1 as Int / num2 as Int
                }
            }

            if (true_res == res) {
                score_text.setText("Yep! That's correct!")
                new_game.visibility = View.VISIBLE
                btn.visibility = View.INVISIBLE
                it.visibility = View.INVISIBLE
            } else {
                score_text.setText("Nooo! That's not correct!")
                new_game.visibility = View.VISIBLE
                btn.visibility = View.INVISIBLE
                it.visibility = View.INVISIBLE
            }
        }
    }

    fun onNoPress(it: View, text: TextView, score_text: TextView, new_game: Button, btn: Button) {
        if (welcome) {
            this.finishAffinity()
        }

        if (!welcome) {
            var true_res = 0;

            when (op) {
                1 -> {
                    true_res = num1 as Int + num2 as Int
                }

                2 -> {
                    true_res = num1 as Int - num2 as Int
                }

                3 -> {
                    true_res = num1 as Int * num2 as Int
                }

                4 -> {
                    true_res = num1 as Int / num2 as Int
                }
            }

            if (true_res !== res) {
                score_text.setText("Yep! That's correct!")
                new_game.visibility = View.VISIBLE
                btn.visibility = View.INVISIBLE
                it.visibility = View.INVISIBLE
            } else {
                score_text.setText("Nooo! That's not correct!")
                new_game.visibility = View.VISIBLE
                btn.visibility = View.INVISIBLE
                it.visibility = View.INVISIBLE
            }
        }
    }

    fun onNewGamePress(it: View, text: TextView, score_text: TextView, new_game: Button, btn_yes: Button, btn_no: Button) {
        generateExpression()

        when (op) {
            1 -> {
                text.setText("$num1 + $num2 = $res")
            }

            2 -> {
                text.setText("$num1 - $num2 = $res")
            }

            3 -> {
                text.setText("$num1 * $num2 = $res")
            }

            4 -> {
                text.setText("$num1 / $num2 = $res")
            }
        }

        score_text.setText("")
        it.visibility = View.INVISIBLE
        btn_yes.visibility = View.VISIBLE
        btn_no.visibility = View.VISIBLE
    }

    fun generateExpression() {
        // Generate numbers
        num1 = (1..100).random()
        num2 = (1..100).random()

        // Generate operator
        op = (1..4).random()

        // False or True
        val c = (0..1).shuffled().last()

        if (c == 0) {
            when (op) {
                1 -> {
                    res = num1 as Int + num2 as Int
                }

                2 -> {
                    res = num1 as Int - num2 as Int
                }

                3 -> {
                    res = num1 as Int * num2 as Int
                }

                4 -> {
                    res = num1 as Int / num2 as Int
                }
            }
        }

        if (c == 1) {
            when (op) {
                1 -> {
                    res = num1 as Int + num2 as Int + (1..10).random()
                }

                2 -> {
                    res = num1 as Int - num2 as Int - (1..10).random()
                }

                3 -> {
                    res = num1 as Int * num2 as Int + (1..10).random()
                }

                4 -> {
                    res = num1 as Int / num2 as Int - (1..10).random()
                }
            }
        }
    }
}