package com.venturelabs.desafio.samara.backend.repository

import com.venturelabs.desafio.samara.backend.model.Voo
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface VooRepository: CrudRepository<Voo, Long> {
//    abstract fun findById(vooID: Int): Optional<Voo>

}
