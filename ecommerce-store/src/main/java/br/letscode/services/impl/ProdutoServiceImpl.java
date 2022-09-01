package br.letscode.services.impl;


import br.letscode.dao.ProdutoDao;
import br.letscode.dto.ProdutoDto;
import br.letscode.models.Produto;
import br.letscode.services.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoDao produtoDao;

    public List<Produto> listarTodosProdutos(){
        return produtoDao.findAll();
    }

    public boolean novoProduto(ProdutoDto produtoDto) {
        try {
            Produto produto = new Produto(produtoDto.getNome(), produtoDto.getPreco(), produtoDto.getDescricao());
            produtoDao.save(produto);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean atualizarProduto(Produto produto) {
        try {
            produtoDao.save(produto);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean removerProduto(long id) {
        try {
            produtoDao.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


}