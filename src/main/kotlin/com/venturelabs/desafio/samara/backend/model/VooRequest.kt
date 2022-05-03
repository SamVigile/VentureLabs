package com.venturelabs.desafio.samara.backend.model

import java.util.*

class VooRequest (

        val horarioSaida: Date,
        val horarioChegada: Date,
        val aeroportoOrigem: String,
        val aeroportoDestino: String,
        val quantidadeAssentos: Int,
        val preco: Long,

        )