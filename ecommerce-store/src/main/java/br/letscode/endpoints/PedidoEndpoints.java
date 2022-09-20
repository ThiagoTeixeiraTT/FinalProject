package br.letscode.endpoints;

import br.letscode.dto.PedidoDto;
import br.letscode.models.AtualizacaoStatusPedido;
import br.letscode.models.Pedido;
import br.letscode.services.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

@RestController
public class PedidoEndpoints {

    @Autowired
    PedidoService pedidoService;

    // Cria pedido.
    @RequestMapping(path = "/pedido", method = RequestMethod.POST)
    public ResponseEntity<String> novoPedido(@RequestBody PedidoDto pedido) {
        boolean sucesso = pedidoService.novoPedido(pedido);

        if (sucesso) {
            return new ResponseEntity<String>("Pedido realizado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Criacao do pedido falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    // Atualiza pedido
    @RequestMapping(path = "/pedido", method = RequestMethod.PUT)
    public ResponseEntity<String> atualizarStatusPedido(@RequestBody AtualizacaoStatusPedido status) {
        boolean sucesso = pedidoService.atualizarStatus(status);

        if (sucesso) {
            return new ResponseEntity<String>("Status atualizado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Atualizacao do status falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    // Lista todos os pedidos de um cliente (por idCliente).
    @RequestMapping(path = "/pedidos/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pedido>> getAllPedidos(@PathVariable long id) {
        List<Pedido> listaPedidos = pedidoService.listarPedidosDoCliente(id);

        return ResponseEntity.ok(listaPedidos);
    }

    // Deleta pedido por Id.
    @RequestMapping(path = "/pedido/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletarPedido(@PathVariable long id) {
        boolean sucesso = pedidoService.deletarPedido(id);

        if (sucesso) {
            return new ResponseEntity<String>("Pedido deletado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Remocao do pedido falhou!", HttpStatus.BAD_REQUEST);
        }
    }

}
