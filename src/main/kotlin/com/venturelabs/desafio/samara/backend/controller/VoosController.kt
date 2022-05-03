package com.venturelabs.desafio.samara.backend.controller


import com.venturelabs.desafio.samara.backend.model.HTTPResponse
import com.venturelabs.desafio.samara.backend.model.VooRequest
import com.venturelabs.desafio.samara.backend.service.VooService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/voo")
@RestController
class VoosController(private val vooService: VooService) {
    @PostMapping("/adicionar")
    fun adicionarVoo( @RequestBody vooRequest: VooRequest): ResponseEntity<HTTPResponse> {

        val vooResponse: HTTPResponse = vooService.criarVoo(vooRequest)

        if (vooResponse.sucesso) {
            return ResponseEntity(vooResponse, HttpStatus.OK)
        } else {
            return ResponseEntity(vooResponse, HttpStatus.NOT_ACCEPTABLE)
        }
    }
}