package com.venturelabs.desafio.samara.backend.controller


import com.venturelabs.desafio.samara.backend.model.ClienteRequest
import com.venturelabs.desafio.samara.backend.model.HTTPResponse
import com.venturelabs.desafio.samara.backend.service.ClienteService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping("/cliente")
@RestController
class ClienteController(private val clienteService: ClienteService) {

    @PostMapping("/adicionar")
    fun adicionarCliente( @RequestBody clienteRequest: ClienteRequest): ResponseEntity<HTTPResponse> {

        val clienteResponse: HTTPResponse = clienteService.adicionarCliente(clienteRequest)

        if (clienteResponse.sucesso) {
            return ResponseEntity(clienteResponse, HttpStatus.OK)
        } else {
            return ResponseEntity(clienteResponse, HttpStatus.BAD_REQUEST)
        }
    }
    @PostMapping("/alterar")
    fun alterarCliente (@RequestBody clienteRequest: ClienteRequest): ResponseEntity<HTTPResponse>
    {
        val clienteAlterar: HTTPResponse = clienteService.alterarCliente(clienteRequest)

        if (clienteAlterar.sucesso) {
            return ResponseEntity(clienteAlterar, HttpStatus.OK)
        } else {
            return ResponseEntity(clienteAlterar, HttpStatus.BAD_REQUEST)
        }
    }
}