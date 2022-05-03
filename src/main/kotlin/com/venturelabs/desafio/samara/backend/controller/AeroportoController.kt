package com.venturelabs.desafio.samara.backend.controller

import com.venturelabs.desafio.samara.backend.model.AeroportoRequest
import com.venturelabs.desafio.samara.backend.model.HTTPResponse
import com.venturelabs.desafio.samara.backend.service.AeroportoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/aeroporto")
@RestController
class AeroportoController(private val aeroportoService: AeroportoService) {
    @PostMapping("/adicionar")
    fun adicionarVoo( @RequestBody aeroportoRequest: AeroportoRequest): ResponseEntity<HTTPResponse> {

        val vooResponse: HTTPResponse = aeroportoService.adicionarAeroporto(aeroportoRequest)

        if (vooResponse.sucesso) {
            return ResponseEntity(vooResponse, HttpStatus.OK)
        } else {
            return ResponseEntity(vooResponse, HttpStatus.NOT_ACCEPTABLE)
        }
    }


}