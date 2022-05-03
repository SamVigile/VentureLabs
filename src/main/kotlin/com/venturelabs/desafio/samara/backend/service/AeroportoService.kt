package com.venturelabs.desafio.samara.backend.service

import com.venturelabs.desafio.samara.backend.model.Aeroporto
import com.venturelabs.desafio.samara.backend.model.AeroportoRequest
import com.venturelabs.desafio.samara.backend.model.HTTPResponse
import com.venturelabs.desafio.samara.backend.repository.AeroportoRepository
import org.springframework.stereotype.Service

@Service
class AeroportoService(private val aeroportoRepository: AeroportoRepository) {
    fun adicionarAeroporto(aeroportoRequest: AeroportoRequest): HTTPResponse {
        val aeroportoOrigem = aeroportoRepository.findByCodigoAeroporto(aeroportoRequest.codigoAeroporto);
        if (aeroportoOrigem != null) {
            return HTTPResponse(false, "Aeroporto já cadastrado")
        }

        val save = aeroportoRepository.save(Aeroporto(aeroportoRequest))
        return HTTPResponse(true, "Aeroporto cadastrado com sucesso! id: " +
                "${save.id}")

    }




}