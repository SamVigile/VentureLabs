package com.venturelabs.desafio.samara.backend.model

import javax.persistence.*

@Table(name = "ASSENTOS")
@Entity
@SequenceGenerator(name = "ASSENTOS_SEQ", sequenceName = "ASSENTOS_SEQ", initialValue = 1, allocationSize = 1)
 class Assento (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ASSENTOS_SEQ")
    @Column(name = "ID")
    val id: Long,

    @OneToOne
    @JoinColumn(name = "VOO_ID", foreignKey = ForeignKey(name = "FK_VOO_ID_ASSENTOS"))
    var voo: Voo,

    @Column(name = "ASSENTO_NUMERO")
    var numeroAssento: String,

    @OneToOne
    @JoinColumn(name = "CLIENTE_CODIGO", foreignKey = ForeignKey(name = "FK_CLIENTE_CODIGO_ASSENTOS"))
    val cliente: Cliente,

) {
    constructor() : this(0L,Voo(), "",Cliente())

    }
