package br.letscode.endpoints;

import br.letscode.dto.ProdutoDto;
import br.letscode.models.Produto;
import br.letscode.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProdutosEndpoints {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(path="/produtos", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> getAllCients() {
        List<Produto> produtoList = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(produtoList);
    }

    @RequestMapping(path="/produto", method = RequestMethod.POST)
    public ResponseEntity novoProduto(@RequestBody ProdutoDto produto) {
        boolean sucesso = produtoService.novoProduto(produto);

        if(sucesso) {
            return new ResponseEntity("Produto criado com sucesso!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity("Criacao do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/produto", method = RequestMethod.PUT)
    public ResponseEntity atualizarProduto(@RequestBody Produto produto) {
        boolean sucesso = produtoService.atualizarProduto(produto);

        if(sucesso) {
            return new ResponseEntity("Produto atualizado com sucesso!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity("Atualizacao do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity removerProduto(@PathVariable long id) {
        boolean sucesso = produtoService.removerProduto(id);

        if(sucesso) {
            return new ResponseEntity("Produto deletado com sucesso!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Remocao do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }
}
