package com.example.lesktllifecycle

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lesktllifecycle.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.toolbarSecond.title = "Индекс массы тела"
        binding.toolbarSecond.subtitle = "версия 1.0"


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val result = intent.getStringExtra("key")
        binding.resultTV.text = "$result"


        when (binding.resultTV.text.toString().toDouble()) {
            in 0.0..18.5 -> {
                binding.infoTV.text = "Низкая масса тела"
                binding.imageIV.setImageResource(R.drawable.imt1)
            }

            in 18.51..24.9 -> {
                binding.infoTV.text = "Нормальная масса тела"
                binding.imageIV.setImageResource(R.drawable.imt2)
            }

            in 24.91..29.9 -> {
                binding.infoTV.text = "Предожирение"
                binding.imageIV.setImageResource(R.drawable.imt3)
            }

            in 29.91..34.9 -> {
                binding.infoTV.text = "Ожирение"
                binding.imageIV.setImageResource(R.drawable.imt4)
            }

            in 34.91..99999.99 -> {
                binding.infoTV.text = "Высокая степень ожирения"
                binding.imageIV.setImageResource(R.drawable.imt5)
            }

            else -> {
                binding.infoTV.text = "Ошибка в расчетах"
                binding.imageIV.setImageResource(R.drawable.imt6)
            }
        }
    }
}