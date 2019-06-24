package com.example.bbs.presentation

import com.example.bbs.application.BbsRepository
import com.example.bbs.domain.Bbs
import com.example.bbs.domain.FieldError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("bbs")
class BbsController(private val bbsRepository: BbsRepository) {

    @GetMapping
    fun list(): List<Bbs> = bbsRepository.findAll()

    @PostMapping
    fun write(@Validated @RequestBody bbs: Bbs): Bbs = bbsRepository.write(bbs)

    @DeleteMapping(path = ["{id}"])
    fun delete(@PathVariable id: Long): Bbs = bbsRepository.delete(id)

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseBody
    fun handleValidationException(e: MethodArgumentNotValidException): ResponseEntity<Any> {
        val body = FieldError(e.bindingResult.fieldErrors[0].field, e.bindingResult.fieldErrors[0].defaultMessage
            ?: "エラーがあります")
        return ResponseEntity(body, HttpStatus.BAD_REQUEST)
    }
}
