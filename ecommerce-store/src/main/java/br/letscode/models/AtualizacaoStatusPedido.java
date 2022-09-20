package br.letscode.models;

import lombok.Getter;
import lombok.Setter;

public class AtualizacaoStatusPedido {

    @Getter
    @Setter
    private Long idPedido;
    @Getter
    @Setter
    private EnumStatusPedido status;

    public AtualizacaoStatusPedido(Long idPedido, EnumStatusPedido status) {
        this.idPedido = idPedido;
        this.status = status;
    }

}
