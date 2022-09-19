package br.letscode.models;

import lombok.Getter;
import lombok.Setter;

public enum EnumStatusPedido {
    CONFIRMADO("CONFIRMADO"),
    EMANDAMENTO("EM ANDAMENTO"),
    CONCLUIDO("CONCLUÍDO"),
    CANCELADO("CANCELADO");

    @Getter
    @Setter
    private String status;

    EnumStatusPedido(String status) {
        this.status = status;

    } 

}
