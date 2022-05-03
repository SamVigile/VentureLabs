package com.venturelabs.desafio.samara.backend.model

import java.util.*
import javax.persistence.*

@Table(name = "PASSAGENS")
@Entity
@SequenceGenerator(name = "PASSAGENS_SEQ", sequenceName = "PASSAGENS_SEQ", initialValue = 1, allocationSize = 1)
 class Passagem (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PASSAGENS_SEQ")
    @Column(name = "ID")
    val id: Long,

    @Column(name = "PASSAGEM_VOO_ID")
    val vooID: String,

    @Column(name = "PASSAGEM_ASSENTO_ID")
    val assentoID: String,

    @Column(name = "PASSAGEM_CLIENT_ID")
    val clienteID: String,

//    @Column(name = "AEROPORTO_DESTINO")
//    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @Column(name = "PASSAGEM_DATACOMPRA")
    val dataCompra: Date,

    @Column(name = "PASSAGEM_ID")
    val idPassagem: String
) {
    constructor() : this(0L, "", "", "", Date(),"")
   constructor( request : PassagemRequest) : this(0L, request.vooID.toString(), request.numeroAssento.toString(),
      request.clienteCpf,request.dataCompra,request.vooID.toString() +request.numeroAssento.toString())

   override fun toString(): String {
      return "Passagem(id=$id, vooID='$vooID', assentoID='$assentoID', clienteID='$clienteID', dataCompra=$dataCompra, idPassagem='$idPassagem')"
   }


}
