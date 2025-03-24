package com.example.onlinecoffeeshopapp.Activity

import android.content.Intent
import android.os.Bundle
import com.example.onlinecoffeeshopapp.databinding.ActivityIntroBinding


class IntroActivity : FlagActivity() {
    lateinit var binding:ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startBtn.setOnClickListener{
            startActivity(Intent(this@IntroActivity, MainActivity::class.java))

        }

    }
}