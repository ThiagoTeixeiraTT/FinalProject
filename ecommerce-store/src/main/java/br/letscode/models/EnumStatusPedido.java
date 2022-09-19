package br.letscode.models;

import lombok.Getter;
import lombok.Setter;

public enum EnumStatusPedido {
    CONFIRMADO("CONFIRMADO"),
    EMANDAMENTO("EM ANDAMENTO"),
    CONCLUIDO("CONCLUÍDO");

    @Getter
    @Setter
    private String status;

    EnumStatusPedido(String status) {
        this.status = status;

    } 

}
