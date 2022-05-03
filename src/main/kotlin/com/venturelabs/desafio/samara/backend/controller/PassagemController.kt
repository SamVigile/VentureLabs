package com.venturelabs.desafio.samara.backend.controller


import com.venturelabs.desafio.samara.backend.model.HTTPResponse
import com.venturelabs.desafio.samara.backend.model.Passagem
import com.venturelabs.desafio.samara.backend.model.PassagemDetalhe
import com.venturelabs.desafio.samara.backend.model.PassagemRequest
import com.venturelabs.desafio.samara.backend.service.PassagemService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RequestMapping("/passagem")
@RestController
class PassagemController(private val passagemService: PassagemService) {



    @PostMapping("/comprar")
    fun comprarPassagem( @RequestBody passagemRequest: PassagemRequest): ResponseEntity<HTTPResponse> {

        val passagemResponse: HTTPResponse = passagemService.comprarPassagem(passagemRequest)

        if (passagemResponse.sucesso) {
            return ResponseEntity(passagemResponse, HttpStatus.OK)
        } else {
            return ResponseEntity(passagemResponse, HttpStatus.NOT_ACCEPTABLE)
        }
    }


    @GetMapping("/listarByClient/{idCliente}")
    fun listarComprasCliente(@PathVariable("idCliente") idCliente: String): List<Passagem>{
        return passagemService.listarComprasCliente(idCliente)
    }
    @GetMapping("/listarByVoo/{idVoo}")
    fun listarPassagensPorVoo(@PathVariable("idVoo") idVoo: String): List<Passagem>{
        return passagemService.listarPassagensPorVoo(idVoo)
    }

    @GetMapping("/detalhesPassagem/{idPassagem}")
    fun detalhesPassagemAerea(@PathVariable("idPassagem") idPassagem: String): PassagemDetalhe {
        return passagemService.detalhesPassagemAerea(idPassagem)
    }
}