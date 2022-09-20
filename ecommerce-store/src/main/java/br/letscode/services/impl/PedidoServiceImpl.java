package br.letscode.services.impl;

import br.letscode.dao.ClienteDao;
import br.letscode.dao.PedidoDao;
import br.letscode.dao.ProdutoDao;
import br.letscode.dto.PedidoDto;
import br.letscode.models.AtualizacaoStatusPedido;
import br.letscode.models.EnumStatusPedido;
import br.letscode.models.Pedido;
import br.letscode.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoDao pedidoDao;
    @Autowired
    ProdutoDao produtoDao;
    @Autowired
    ClienteDao clienteDao;

    @Override
    public List<Pedido> listarPedidosDoCliente(Long idCliente) {
        return pedidoDao.findAll()
        .stream()
        .filter(pedidos -> idCliente == pedidos.getCliente().getId())
        .collect(Collectors.toList());

    }

    @Override
    public boolean novoPedido(PedidoDto pedidoDto) {
        try {
            Pedido pedido = new Pedido(clienteDao.getById(pedidoDto.getIdCliente()),
                    produtoDao.getById(pedidoDto.getIdProduto()), pedidoDto.getQuantidade());
                    pedido.setDataPedido(LocalDateTime.now());
            pedidoDao.save(pedido);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean atualizarStatus(AtualizacaoStatusPedido status) {
        try {
            Pedido pedido = pedidoDao.getById(status.getIdPedido());
            pedido.setStatus(status.getStatus());
            pedidoDao.save(pedido);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean deletarPedido(long id) {
        try {
            pedidoDao.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}