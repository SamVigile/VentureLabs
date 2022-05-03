package com.venturelabs.desafio.samara.backend.repository

import com.venturelabs.desafio.samara.backend.model.Aeroporto
import org.springframework.data.repository.CrudRepository
import org.springframework.lang.Nullable
import org.springframework.stereotype.Repository

@Repository
interface AeroportoRepository: CrudRepository<Aeroporto, Long> {
    @Nullable
    fun findByCodigoAeroporto(aeroportoOrigem: String): Aeroporto


}

