package br.letscode.services;

import br.letscode.dto.PedidoDto;
import br.letscode.models.Pedido;
import br.letscode.models.AtualizacaoStatusPedido;

import java.util.List;

public interface PedidoService {
    List<Pedido> listarPedidosDoCliente(long idCliente);

    boolean novoPedido(PedidoDto pedidoDto);

    boolean atualizarStatus(AtualizacaoStatusPedido status);

    boolean deletarPedido(long idPedido);

}
