package org.acano99.my_home.domain.helpers

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@RequiresApi(Build.VERSION_CODES.O)
actual fun getDayFromMillisecondsEpoch(dateMilliseconds: Long): String {
    val instant = Instant.ofEpochMilli(dateMilliseconds)
    val convertedDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault())
    return "${convertedDate.dayOfMonth}"
}