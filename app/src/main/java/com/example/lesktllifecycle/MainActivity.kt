package com.example.lesktllifecycle

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lesktllifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarMain.title = "Индекс массы тела"
        binding.toolbarMain.subtitle = "версия 1.0"
        binding.resultBTN.setOnClickListener {

            if (binding.heightET.text.isEmpty() || binding.weightET.text.isEmpty() || binding.heightET.text.toString()
                    .toDouble() < 1
            ) {
                Toast.makeText(this, "Ошибка ввода данных", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(
                "key",
                BodyMassIndex().checkMass(
                    binding.weightET.text.toString().toDouble(),
                    binding.heightET.text.toString().toDouble()
                ).toString()
            )
            startActivity(intent)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
