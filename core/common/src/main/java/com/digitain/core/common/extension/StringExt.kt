package com.digitain.core.common.extension

import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

fun String.formatDateTime(): String {
    val cleaned = this.replace('\u202F', ' ').replace('\u00A0', ' ')
    val inputFormatter = DateTimeFormatter.ofPattern("M/d/yyyy h:mm:ss a XXX")

    val dateTime = OffsetDateTime.parse(cleaned, inputFormatter)

    val dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
    val timeFormatter = DateTimeFormatter.ofPattern("HH:mm")

    return "${dateTime.format(dateFormatter)} | ${dateTime.format(timeFormatter)}"
}