package com.venturelabs.desafio.samara.backend.model

class PassagemDetalhe {
    var passagem: Passagem
    var voo: Voo

    constructor(passagem: Passagem, voo: Voo) {
        this.passagem = passagem
        this.voo = voo
    }
}