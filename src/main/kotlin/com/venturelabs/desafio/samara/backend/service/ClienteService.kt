package com.venturelabs.desafio.samara.backend.service

import com.venturelabs.desafio.samara.backend.model.Cliente
import com.venturelabs.desafio.samara.backend.model.ClienteRequest
import com.venturelabs.desafio.samara.backend.model.HTTPResponse
import com.venturelabs.desafio.samara.backend.repository.ClienteRepository
import org.springframework.stereotype.Service

@Service
class ClienteService(private val clienteRepository: ClienteRepository) {
    fun adicionarCliente(clienteRequest: ClienteRequest): HTTPResponse {
        val cliente = clienteRepository.findByCpf(clienteRequest.cpf)
        if (cliente != null) {
            return HTTPResponse(false, "Cliente já cadastrado")
        }

        val save = clienteRepository.save(Cliente(clienteRequest))
        return HTTPResponse(true, "Cliente cadastrado com sucesso! id: " +
                "${save.id}")

    }

    fun alterarCliente(clienteRequest: ClienteRequest): HTTPResponse {

        var cliente = clienteRepository.findByCpf(clienteRequest.cpf)

        if (cliente == null){
            return HTTPResponse(false, "Cliente Inexistente")
        } else {

        cliente.nome = clienteRequest.nome
            cliente.dataNascimento = clienteRequest.dataNascimento
            cliente.endereco = clienteRequest.endereco
            cliente.telefone = clienteRequest.telefone

            val save = clienteRepository.save(cliente)

            return HTTPResponse (true, "Cliente alterado com sucesso!")
    }
}
}