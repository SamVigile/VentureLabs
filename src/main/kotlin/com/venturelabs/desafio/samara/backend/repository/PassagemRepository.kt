package com.venturelabs.desafio.samara.backend.repository

import com.venturelabs.desafio.samara.backend.model.Passagem
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PassagemRepository: CrudRepository<Passagem, Long> {
    abstract fun findAllByClienteID(id: String): List<Passagem>
    abstract fun findAllByVooID(toString: String): List<Passagem>


}

