package com.capstone.basickotlin

import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.capstone.basickotlin.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 뷰바인딩 초기화
        val binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        //redBtn 리스너 설정
        binding.redBtn.setOnClickListener {
            binding.redBtn.isSelected = binding.redBtn.isSelected != true
        }

        //blackBtn 리스너 설정
        binding.blackBtn.setOnClickListener {
            binding.blackBtn.isSelected = binding.blackBtn.isSelected != true
        }

        //yellowBtn 리스너 설정
        binding.yellowBtn.setOnClickListener {
            binding.yellowBtn.isSelected = binding.yellowBtn.isSelected != true
        }

        //blueBtn 리스너 설정
        binding.blueBtn.setOnClickListener {
            binding.blueBtn.isSelected = binding.blueBtn.isSelected != true
        }

    }


}


