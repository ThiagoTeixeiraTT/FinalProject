package br.letscode.dto;

import java.time.LocalDateTime;

import br.letscode.models.EnumStatusPedido;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoDto {

    private Long idCliente;
    private Long idProduto;
    private long quantidade;
    private LocalDateTime DataPedido;
    private EnumStatusPedido status;
    
    public PedidoDto(Long cliente, Long produto, long quantidade) {
        this.idCliente = cliente;
        this.idProduto = produto;
        this.quantidade = quantidade;

    }


}
