package com.venturelabs.desafio.samara.backend.model

import java.util.*
import javax.persistence.*

@Table(name = "VOOS")
@Entity
@SequenceGenerator(name = "VOOS_SEQ", sequenceName = "VOOS_SEQ", initialValue = 1, allocationSize = 1)
 class Voo (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOOS_SEQ")
    @Column(name = "ID")
    val id: Long,

    @Column(name = "HORARIO_SAIDA")
    val horarioSaida: Date,

    @Column(name = "HORARIO_CHEGADA")
    val horarioChegada: Date,

//    @Column(name = "AEROPORTO_ORIGEM")
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OneToOne
    @JoinColumn(name = "AEROPORTO_CODIGO", foreignKey = ForeignKey(name = "FK_AEROPORTO_CODIGO"))
    val aeroportoOrigem: Aeroporto,

//    @Column(name = "AEROPORTO_DESTINO")
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @OneToOne
    @JoinColumn(name = "FK_AEROPORTO_CODIGO", foreignKey = ForeignKey(name = "AEROPORTO_ID"))
    val aeroportoDestino: Aeroporto,

    @Column(name = "VOO_NUMERO_ASSENTOS")
    val numeroAssentos: Int,

    @Column(name = "PRECO_PASSAGEM")
    val precoPassagem: Long
) {
    constructor() : this(0L, Date(), Date(), Aeroporto(), Aeroporto(),0, 0L)

 }
