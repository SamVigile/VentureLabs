package com.venturelabs.desafio.samara.backend.model

import javax.persistence.*

@Table(name = "AEROPORTOS")
@Entity
@SequenceGenerator(name = "AEROPORTOS_SEQ", sequenceName = "AEROPORTO_SEQ", initialValue = 1, allocationSize = 1)
 class Aeroporto (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AEROPORTO_SEQ")
    @Column(name = "ID")
    val id: Long,

    @Column(name = "AEROPORTO_NOME")
    val nome: String,

    @Column(name = "AEROPORT_CIDADE")
    val cidade: String,

    @Column(name = "AEROPORTO_PAIS")
    val pais: String,

    @Column(name = "AEROPORTO_CODIGO")
    val codigoAeroporto: String,

) {
    constructor() : this(0L,"", "", "", "")

    constructor( request : AeroportoRequest) : this(0L, request.nome,request.cidade,
    request.pais,request.codigoAeroporto)
 }
