package com.capstone.studykotlinbottomicon

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

class CalenderUtil {
    companion object{
        @RequiresApi(Build.VERSION_CODES.O)
        var selectedDate: LocalDate = LocalDate.now()
    }
}