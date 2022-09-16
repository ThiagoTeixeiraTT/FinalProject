package br.letscode.endpoints;

import br.letscode.dto.ProdutoDto;
import br.letscode.models.Produto;
import br.letscode.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class ProdutosEndpoints {

    @Autowired
    ProdutoService produtoService;
    
    // Cria produto.
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(path = "/produto", method = RequestMethod.POST)
    public ResponseEntity<String> novoProduto(@RequestBody ProdutoDto produto) {
        boolean sucesso = produtoService.novoProduto(produto);
        
        if (sucesso) {
            return new ResponseEntity<String>("Produto criado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Criacao do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }
    
    // Atualiza produto
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/produto", method = RequestMethod.PUT)
    public ResponseEntity<String> atualizarProduto(@RequestBody Produto produto) {
        boolean sucesso = produtoService.atualizarProduto(produto);
        
        if (sucesso) {
            return new ResponseEntity<String>("Produto atualizado com sucesso!", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<String>("Atualizacao do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }
    
    // Deleta produto por Id.
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/produto/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removerProduto(@PathVariable long id) {
        boolean sucesso = produtoService.removerProduto(id);
        
        if (sucesso) {
            return new ResponseEntity<String>("Produto deletado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Remocao do produto falhou!", HttpStatus.BAD_REQUEST);
        }
    }
    
    // Retorna produto por Id.
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(path = "/produto/{id}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProductById(@PathVariable long id) {
        Optional<Produto> produto = produtoService.produtoPorId(id);
        if (produto.isEmpty()) {
            return new ResponseEntity<String>("Produto não existe!", HttpStatus.BAD_REQUEST);
        } else {
            return ResponseEntity.ok(produto);
        }
        
    }
    
    // Lista todos os produtos.
    @RequestMapping(path = "/produtos", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Produto>> getAllProducts() {
        List<Produto> produtoList = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(produtoList);
    }
}
