package com.venturelabs.desafio.samara.backend.service

import com.venturelabs.desafio.samara.backend.model.Assento
import com.venturelabs.desafio.samara.backend.model.HTTPResponse
import com.venturelabs.desafio.samara.backend.model.Passagem
import com.venturelabs.desafio.samara.backend.model.PassagemRequest
import com.venturelabs.desafio.samara.backend.repository.AssentoRepository
import com.venturelabs.desafio.samara.backend.repository.ClienteRepository
import com.venturelabs.desafio.samara.backend.repository.PassagemRepository
import com.venturelabs.desafio.samara.backend.repository.VooRepository
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class PassagemService(private val passagemRepository: PassagemRepository,
                      private val clienteRepository: ClienteRepository,
                      private val vooRepository: VooRepository,
                      private val assentoRepository: AssentoRepository
) {
    @Transactional
    fun comprarPassagem(passagemRequest: PassagemRequest): HTTPResponse {

        val voo = vooRepository.findById(passagemRequest.vooID.toLong());
        if (voo.isEmpty ) {
            return HTTPResponse(false, "Voo nao encontrado")
        }

        val cliente = clienteRepository.findByCpf(passagemRequest.clienteCpf);
        if (cliente == null) {
            return HTTPResponse(false, "Cliente nao encontrado")
        }

        val assento = assentoRepository.findAllByVooAndNumeroAssento(voo.get(), passagemRequest.numeroAssento.toString());
        if (assento != null && assento.isNotEmpty()) {
            return HTTPResponse(false, "Assento ja comprado")
        }

        val assentos: List<Assento> = assentoRepository.findAllByVoo(voo.get());
        if (assentos.size >= voo.get().numeroAssentos) {
            return HTTPResponse(false, "Nao ha assentos disponiveis")
        }
        var assentoDTO = Assento(0L, voo.get(), passagemRequest.numeroAssento.toString(), cliente)
        assentoDTO = assentoRepository.save(assentoDTO)






        val save = passagemRepository.save(Passagem(passagemRequest))
        return HTTPResponse(true, "Passagem comprada com sucesso! Sua Passagem é: " +
                "${save.toString()}")

    }

    fun listarComprasCliente(clienteBusca: String): List<Passagem> {

        var cliente = clienteRepository.findById(clienteBusca.toLong());

        if (cliente == null) {
            return listOf()
        } else {
            val findAllByClienteID = passagemRepository.findAllByClienteID(cliente.get().cpf.toString())
            if (findAllByClienteID.isEmpty()) {
                return arrayListOf()
            } else {
                return findAllByClienteID
            }
        }
    }

    fun listarPassagensPorVoo(idVoo: String): List<Passagem> {
        var voo = vooRepository.findById(idVoo.toLong());
        if (voo == null) {
            return listOf()
        } else {
            val findAllByVooID = passagemRepository.findAllByVooID(voo.get().id.toString())
            if (findAllByVooID.isEmpty()) {
                return arrayListOf()
            } else {
                return findAllByVooID
            }
        }
    }


    fun detalhesPassagemAerea(idPassagem: String): Optional<Passagem> {
        var passagem = passagemRepository.findById(idPassagem.toLong());
        if (!passagem.isPresent) {
            throw TypeNotPresentException("Passagem nao encontrada", null)
        }
        return passagem;

}

}
