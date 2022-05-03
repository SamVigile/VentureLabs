package com.venturelabs.desafio.samara.backend.service


import com.venturelabs.desafio.samara.backend.model.HTTPResponse
import com.venturelabs.desafio.samara.backend.model.Voo
import com.venturelabs.desafio.samara.backend.model.VooRequest
import com.venturelabs.desafio.samara.backend.repository.AeroportoRepository
import com.venturelabs.desafio.samara.backend.repository.VooRepository
import org.springframework.stereotype.Service

@Service
class VooService(private val vooRepository: VooRepository, private val aeroportoRepository: AeroportoRepository) {
    fun criarVoo(vooRequest: VooRequest): HTTPResponse {

        val aeroportoOrigem = aeroportoRepository.findByCodigoAeroporto(vooRequest.aeroportoOrigem)
        val aeroportoDestino = aeroportoRepository.findByCodigoAeroporto(vooRequest.aeroportoDestino)
        if (aeroportoOrigem == null || aeroportoDestino == null) {
            return HTTPResponse(false, "Aeroporto não encontrado")
        }
        val voo: Voo = Voo(0L, vooRequest.horarioSaida,vooRequest.horarioChegada,
            aeroportoOrigem,aeroportoDestino,vooRequest.quantidadeAssentos,vooRequest.preco
        )
        val save = vooRepository.save(voo)
        return HTTPResponse(true, "Voo criado com sucesso! id: " +
                "${save.id}")

    }

}