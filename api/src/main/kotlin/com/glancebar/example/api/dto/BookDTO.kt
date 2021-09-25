package com.glancebar.example.api.dto


import java.io.Serializable
import java.time.LocalDate
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull


/**
 *
 * @author YISHEN CAI
 */
class BookDTO : Serializable {
    @NotEmpty(message = "...")
    lateinit var name: String

    @NotEmpty(message = "...")
    lateinit var isbn: String

    @NotNull(message = "...")
    lateinit var publishDate: LocalDate
}