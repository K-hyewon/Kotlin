package com.capstone.studykotlinbottomicon

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.capstone.studykotlinbottomicon.databinding.ActivityNoteBinding


class NoteActivity : AppCompatActivity(), View.OnClickListener {
    // binding을 초기화한다.
    private lateinit var binding : ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        //        //binding을 초기화한다.
//        val binding = ActivityNoteBinding.inflate(layoutInflater);
        binding = ActivityNoteBinding.inflate(layoutInflater)
        val view = binding.root

        // root뷰(레이아웃)을 화면에 표시하도록 설정한다.
//        setContentView(binding.root);
        setContentView(view);


        // MainActivity에서 intent로 보낸 값들 받아오기 (달력에서 클릭한 년,월,일)
        var iyear = intent.getStringExtra("iYear")
        var imonth = intent.getStringExtra("iMonth")
        var iday = intent.getStringExtra("iDay")

        // 달력에서 클릭한 날짜 상단에 띄우기 - activity_note.xml에 있는 dayTv에 값을 할당
        binding.dayTv.text = "%s년  %s월  %s일".format(iyear, imonth, iday)


//        //redBtn 리스너 설정
//        binding.redBtn.setOnClickListener {
//            binding.redBtn.isSelected = binding.redBtn.isSelected != true
//        }
//
//        //blackBtn 리스너 설정
//        binding.blackBtn.setOnClickListener {
//            binding.blackBtn.isSelected = binding.blackBtn.isSelected != true
//        }
//
//        //yellowBtn 리스너 설정
//        binding.yellowBtn.setOnClickListener {
//            binding.yellowBtn.isSelected = binding.yellowBtn.isSelected != true
//        }
//
//        //blueBtn 리스너 설정
//        binding.blueBtn.setOnClickListener {
//            binding.blueBtn.isSelected = binding.blueBtn.isSelected != true
//        }

        // 공통 리스너 작성
        binding.redBtn.setOnClickListener(this)
        binding.yellowBtn.setOnClickListener(this)
        binding.blackBtn.setOnClickListener(this)
        binding.blueBtn.setOnClickListener(this)

        // 뒤로가기 버튼
        binding.btnClose.setOnClickListener {
            val intent = Intent()
            intent.putExtra("comeback", binding.etComback.text.toString())
            setResult(RESULT_OK, intent)
            finish()
    }

    override fun onClick(v: View?){
        when(v?.id){
            binding.redBtn.id -> binding.redBtn.isSelected = binding.redBtn.isSelected != true
            binding.yellowBtn.id -> binding.yellowBtn.isSelected = binding.yellowBtn.isSelected != true
            binding.blackBtn.id -> binding.blackBtn.isSelected = binding.blackBtn.isSelected != true
            binding.blueBtn.id -> binding.blueBtn.isSelected = binding.blueBtn.isSelected != true
        }
    }
}