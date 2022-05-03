package com.venturelabs.desafio.samara.backend.model

import javax.persistence.*

@Table(name = "CLIENTES")
@Entity
@SequenceGenerator(name = "CLIENTES_SEQ", sequenceName = "CLIENTES_SEQ", initialValue = 1, allocationSize = 1)
 class Cliente (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTES_SEQ")
    @Column(name = "ID")
    val id: Long,

    @Column(name = "CLIENTE_NOME")
    var nome: String,

    @Column(name = "CLIENTE_DATANASCIMENTO")
    var dataNascimento: String,

    @Column(name = "CLIENTE_ENDERECO")
    var endereco: String,

    @Column(name = "CLIENTE_CPF")
    val cpf: String,

    @Column(name = "CLIENTE_TELEFONE")
    var telefone: String,

) {
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "passagens_id")
    open var passagens: Passagem? = null

    constructor() : this(0L,"", "", "", "","")

    constructor( request : ClienteRequest) : this(0L, request.nome,request.dataNascimento,
    request.endereco,request.cpf,request.telefone)
 }
