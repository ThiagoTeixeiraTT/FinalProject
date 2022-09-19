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
    private Long quantidade;
    private LocalDateTime DataPedido;
    private EnumStatusPedido status;
    
    public PedidoDto(Long cliente, Long produto, Long quantidade) {

    }


}
