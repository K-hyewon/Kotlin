package com.capstone.studykotlinbottomicon

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDate
import java.time.format.DateTimeFormatter


class CalenderAdapter(private val dayList: ArrayList<LocalDate?>):
    RecyclerView.Adapter<CalenderAdapter.ItemViewHolder>() {

    // 0611 - 변환
//    private lateinit var mActivityResultLauncher : ActivityResultLauncher<Intent>


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dayText: TextView = itemView.findViewById(R.id.dayText)
        val redIcon: ImageView = itemView.findViewById(R.id.redIcon)
        val blackIcon: ImageView = itemView.findViewById(R.id.blackIcon)
        val yellowIcon: ImageView = itemView.findViewById(R.id.yellowIcon)
        val blueIcon: ImageView = itemView.findViewById(R.id.blueIcon)
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
//                holder.blueIcon.visibi5lity = View.VISIBLE
            }
        }


        //텍스트 색상 지정 (토,일)
        if ((position + 1) % 7 == 0) {
            holder.dayText.setTextColor(Color.BLUE)  //토요일은 파란색
        } else if (position == 0 || position % 7 == 0) {
            holder.dayText.setTextColor(Color.RED)  //일요일은 빨간색
        }




        // 클릭리스너 - 날짜 클릭시 noteActivity로 이동
        holder.itemView.setOnClickListener {
            var iYear = day?.year.toString()
            var iMonth = day?.monthValue.toString()
            var iDay = day?.dayOfMonth.toString()

            val intent = Intent(holder.itemView?.context, NoteActivity::class.java)
            intent.putExtra("iYear", iYear)
            intent.putExtra("iMonth", iMonth)
            intent.putExtra("iDay", iDay)
            // 0611 - 기존
            ContextCompat.startActivity(holder.itemView.context, intent, null)
            // 0611 - 변환
//            mActivityResultLauncher.launch(intent)
        }



    }

    override fun getItemCount(): Int {
        return dayList.size
    }

//    // 0611 - 변환
//    private fun getResponseResult() {
//        mActivityResultLauncher = registerForActivityResult
//            (ActivityResultContracts.StartActivityForResult())
//        {result ->
//            if (result.resultCode == RESULT_OK )
//        }
//        )
//    }






}


//1. noteActivity에서 selected정보를 "mainActivity"로 전달한다 ---> O ?
//2. "mainActivity"에서 정보를 받는다
//3. 받은 정보를 해당하는 날짜 itemView에 전달한다
//4. (3)을 전달할 때,  selected=true 이면  해당 ImageView가 View.VISIBLE 되도록 설정한다



