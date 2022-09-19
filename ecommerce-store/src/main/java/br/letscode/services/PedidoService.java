package br.letscode.services;

import br.letscode.dto.PedidoDto;
import br.letscode.models.EnumStatusPedido;
import br.letscode.models.Pedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> listarPedidosDoCliente(long idCliente);

    boolean novoPedido(PedidoDto pedidoDto);

    boolean atualizarStatus(Long idPedido, EnumStatusPedido novoStatus);

    boolean cacelarPedido(long idPedido);

}
