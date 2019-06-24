package com.example.bbs.domain

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime
import javax.validation.constraints.NotBlank

data class Bbs(

    val id: Long,

    val name: String = "名無しさん",

    @field:NotBlank(message = "本文が入力されていません")
    val content: String,

    @get:JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd hh:mm:ss")
    val datetime: LocalDateTime = LocalDateTime.now(),

    val deleted: Boolean = false
)
