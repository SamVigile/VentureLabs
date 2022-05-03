package com.venturelabs.desafio.samara.backend.repository

import com.venturelabs.desafio.samara.backend.model.Cliente
import org.springframework.data.repository.CrudRepository
import org.springframework.lang.Nullable
import org.springframework.stereotype.Repository

@Repository
interface ClienteRepository: CrudRepository<Cliente, Long> {
    @Nullable
    fun findByCpf(cpf: String): Cliente


}

