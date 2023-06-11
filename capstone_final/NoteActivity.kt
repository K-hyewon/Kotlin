package com.capstone.studykotlinbottomicon

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.capstone.studykotlinbottomicon.databinding.ActivityNoteBinding


class NoteActivity : AppCompatActivity(), View.OnClickListener {
    // binding을 초기화한다.
    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        //binding을 초기화한다.
        val binding = ActivityNoteBinding.inflate(layoutInflater);


        // root뷰(레이아웃)을 화면에 표시하도록 설정한다.
        setContentView(binding.root);

        // MainActivity에서 intent로 보낸 값들 받아오기 (달력에서 클릭한 년,월,일)
        var iyear = intent.getStringExtra("iYear")
        var imonth = intent.getStringExtra("iMonth")
        var iday = intent.getStringExtra("iDay")

        // 달력에서 클릭한 날짜 상단에 띄우기 - activity_note.xml에 있는 dayTv에 값을 할당
        binding.dayTv.text = "%s년  %s월  %s일".format(iyear, imonth, iday)


        //redBtn 리스너 설정
        binding.redBtn.setOnClickListener {
            binding.redBtn.isSelected = binding.redBtn.isSelected != true
            //메인에 전달할 값을 저장한다.
            var redSt = binding.redBtn.isSelected
            val btnState1 = Intent();
            btnState1.putExtra("redBtn_state", redSt);
            //저장한 값을 MainActivity로 전송
            setResult(RESULT_OK, btnState1)
        }

        //blackBtn 리스너 설정
        binding.blackBtn.setOnClickListener {
            binding.blackBtn.isSelected = binding.blackBtn.isSelected != true
            //메인에 전달할 값을 저장한다.
            var blackSt: String = binding.redBtn.isSelected.toString()
            val intent = Intent();
            intent.putExtra("blackBtn_state", blackSt);
        }

        //yellowBtn 리스너 설정
        binding.yellowBtn.setOnClickListener {
            binding.yellowBtn.isSelected = binding.yellowBtn.isSelected != true
            //메인에 전달할 값을 저장한다.
            var yellowSt: String = binding.redBtn.isSelected.toString()
            val intent = Intent();
            intent.putExtra("yellowBtn_state", yellowSt);
        }

        //blueBtn 리스너 설정
        binding.blueBtn.setOnClickListener {
            binding.blueBtn.isSelected = binding.blueBtn.isSelected != true
            //메인에 전달할 값을 저장한다.
            var blueSt: String = binding.redBtn.isSelected.toString()
            val intent = Intent();
            intent.putExtra("blueBtn_state", blueSt);
        }

        //뒤로가기 버튼 작동
        binding.closeBtn.setOnClickListener {
            finish()
        }

    }

    override fun onClick(v: View?) {
//        //메인에 전달할 값을 저장한다.
//        var redSt = binding.redBtn.isSelected.toString()
//        val btnState1 = Intent();
//        btnState1.putExtra("redBtn_state", redSt);
//        //저장한 값을 MainActivity로 전송
//        setResult(RESULT_OK, btnState1)
    }

//        var blackSt: String = binding.redBtn.isSelected.toString()
//        val intent = Intent();
//        intent.putExtra("blackBtn_state", blackSt);
//
//        var yellowSt: String = binding.redBtn.isSelected.toString()
//        val intent = Intent();
//        intent.putExtra("yellowBtn_state", yellowSt);
//
//        var blueSt: String = binding.redBtn.isSelected.toString()
//        val intent = Intent();
//        intent.putExtra("blueBtn_state", blueSt);
//    }

}