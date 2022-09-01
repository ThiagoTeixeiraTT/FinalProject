package br.letscode.services;

import java.util.List;

import br.letscode.dto.ProdutoDto;
import br.letscode.models.Produto;

public interface ProdutoService {
    List<Produto> listarTodosProdutos();

    boolean novoProduto(ProdutoDto produto);

    boolean atualizarProduto(Produto produto);

    boolean removerProduto(long id);



}
