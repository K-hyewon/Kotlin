package com.capstone.studykotlin

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capstone.studykotlin.CalenderUtil.Companion.selectedDate
import com.capstone.studykotlin.databinding.ActivityMainBinding
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // binding 초기화
        binding = DataBindingUtil.setContentView(this , R.layout.activity_main)

        // 현재 날짜
        CalenderUtil.selectedDate = LocalDate.now()

        //화면 설정
        setMonthView()
        //이전달 버튼 이벤트
        binding.preBtn.setOnClickListener{
            //현재 월 -1 변수에 담기
            CalenderUtil.selectedDate = CalenderUtil.selectedDate.minusMonths(1)
            setMonthView()
        }

        //다음달 버튼 이벤트
        binding.nextBtn.setOnClickListener{
            //현재 월 +1 변수에 담기
            CalenderUtil.selectedDate = CalenderUtil.selectedDate.plusMonths(1)
            setMonthView()
        }
    }

    //날짜 화면에 보여주기
    @RequiresApi(Build.VERSION_CODES.O)
    private fun setMonthView(){ //년월 텍스트 뷰 셋팅
        binding.monthYearText.text = yearMonthFromDate((CalenderUtil.selectedDate))

        //날짜 생성해서 리스트에 담기
        val dayList = dayInMonthArray(CalenderUtil.selectedDate)

        //어뎁터 초기화
        val adapter = CalenderAdapter(dayList)
        //레이아웃 설정(열 7개)
        var manager : RecyclerView.LayoutManager = GridLayoutManager(applicationContext, 7)
        //레이아웃 적용
        binding.recyclerView.layoutManager = manager
        //어뎁터 적용
        binding.recyclerView.adapter = adapter
    }

    //날짜 타입 설정(월, 년)
    @RequiresApi(Build.VERSION_CODES.O)
    private fun yearMonthFromDate(date: LocalDate) : String{
        val formatter = DateTimeFormatter.ofPattern("yyyy  MM월")

        //받아온 날짜를 지정한 포맷으로 변경
        return date.format(formatter)
    }


    //***** 3번째 동영상 수정 부분 ******
    //날짜 생성
    @RequiresApi(Build.VERSION_CODES.O)
    private fun dayInMonthArray(date: LocalDate): ArrayList<LocalDate?>{

        var dayList = ArrayList<LocalDate?>()

        var yearMonth = YearMonth.from(date)

                    //해당 월 마지막 날짜 가져오기 (ex. 28, 30, 31)
                    var lastDay = yearMonth.lengthOfMonth()
                    //해달 월의 첫번째 날 가져오기 (ex. 4월 1일)
                    var firstDay = CalenderUtil.selectedDate.withDayOfMonth(1)
                //첫번째날 요일 가져오기 (ex. 월:1, 일: 7)
                var dayOfweek = firstDay.dayOfWeek.value

                for(i in 1..41){
                    if(i <= dayOfweek || i > (lastDay + dayOfweek)){
                        dayList.add(null)
                    }else{
                        // LocalDate.of(년, 월, 일)
                        dayList.add(LocalDate.of(selectedDate.year,
                    selectedDate.monthValue, i - dayOfweek))
            }
        }
        return dayList
    }




}