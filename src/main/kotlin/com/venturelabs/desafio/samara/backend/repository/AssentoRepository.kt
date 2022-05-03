package com.venturelabs.desafio.samara.backend.repository


import com.venturelabs.desafio.samara.backend.model.Assento
import com.venturelabs.desafio.samara.backend.model.Cliente
import com.venturelabs.desafio.samara.backend.model.Voo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AssentoRepository: CrudRepository<Assento, Long> {
    abstract fun findAllByVoo(get: Voo): List<Assento>
    abstract fun findAllByVooAndNumeroAssento(get: Voo, numeroAssento: String): List<Assento>

    abstract fun findAllByCliente(get: Cliente): List<Assento>

}

