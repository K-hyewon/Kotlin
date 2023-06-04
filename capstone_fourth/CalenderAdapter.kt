package com.capstone.studykotlinbottomicon

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class CalenderAdapter(private val dayList: ArrayList<LocalDate?>):
    RecyclerView.Adapter<CalenderAdapter.ItemViewHolder>() {


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayText: TextView = itemView.findViewById(R.id.dayText)

    }


    //화면 설정
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.calender_item, parent, false)
        return ItemViewHolder((view))
    }


    //데이터 설정 - original
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        //날짜 변수에 담기
        var day = dayList[holder.adapterPosition]

        if (day == null) {
            holder.dayText.text = ""
        } else {
            //해당 일자를 넣는다.
            holder.dayText.text = day.dayOfMonth.toString()
            val nowMonth : String = DateTimeFormatter.ofPattern("MM").toString()

            //현재 날짜 색상 칠하기
            if (day == CalenderUtil.selectedDate ) {
                holder.itemView.setBackgroundColor(Color.LTGRAY)
            }
        }


        //텍스트 색상 지정 (토,일)
        if ((position + 1) % 7 == 0) {
            holder.dayText.setTextColor(Color.BLUE)  //토요일은 파란색
        } else if (position == 0 || position % 7 == 0) {
            holder.dayText.setTextColor(Color.RED)  //일요일은 빨간색
        }

        //날짜 클릭 이벤트
//        holder.itemView.setOnClickListener {
//
//            //인터페이스를 통해 날짜를 넘겨준다.
//            var iYear = day?.year
//            var iMonth = day?.monthValue
//            var iDay = day?.dayOfMonth
//
//            var yearMonthDay = "$iYear 년  $iMonth 월  $iDay 일"
//
//
//            Toast.makeText(holder.itemView.context, yearMonthDay, Toast.LENGTH_SHORT).show()
////                holder.itemView.setBackgroundColor(Color.LTGRAY)  // + 혜원 추가 - 클릭한 itemView 배경색 변경
//
//        }
        holder.itemView.setOnClickListener {
            var iYear = day?.year.toString()
            var iMonth = day?.monthValue.toString()
            var iDay = day?.dayOfMonth.toString()

            val intent = Intent(holder.itemView?.context, NoteActivity::class.java)
            intent.putExtra("iYear", iYear)
            intent.putExtra("iMonth", iMonth)
            intent.putExtra("iDay", iDay)
            ContextCompat.startActivity(holder.itemView.context, intent, null)

        }


    }

    override fun getItemCount(): Int {
        return dayList.size
    }
}




